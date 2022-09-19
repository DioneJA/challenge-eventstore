package CodeImp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.intelie.challenges.Event;
import net.intelie.challenges.EventIterator;
import net.intelie.challenges.EventStore;

/**
 *
 * @author bruno
 */
public class EventStoreImplementation implements EventStore {
	// A concurrentHashMap for Thread Safe, and taking advantage of its O(1) cost
	private final Map<String, Event> eventArray = new ConcurrentHashMap<>();

	// constructor with arguments
	public EventStoreImplementation(Map<String, Event> eventList) {
		setEventArray(eventList);
	}

	/// empty constructor
	public EventStoreImplementation() {
	}

	// getter
	public Map<String, Event> getEventArray() {
		return eventArray;
	}

	// Setter with an exception handling to control what will be inserted, the set
	// is also used in the construct
	public void setEventArray(Map<String, Event> eventList) {
		if (eventList.size() > 0) {
			this.eventArray.putAll(eventList);
		} else {
			throw new EventException("Error! Caused by - Event Map is null");
		}
	}

	// In the key, the type + "," + timestamp is used, so that access is easier, and
	// you can also obtain a type present in the key
	@Override
	public void insert(Event event) {
		if (event != null) {
			eventArray.put(event.type() + "," + event.timestamp(), event);
		} else {
			throw new EventException("Error! Caused by - Event is null");
		}
	}

	// Removing all occurrences of a certain type, using the EventIterator that was
	// implemented to traverse the Event Map
	@Override
	public void removeAll(String type) {
		@SuppressWarnings("resource")
		EventIterator iterator = new EventIteratorImplementation(eventArray);
		while (iterator.moveNext()) {
			try {
				String[] aux = iterator.current().type().split(",");// cutting key to get a certain type
				if (type.equals(aux[0])) {
					iterator.remove();
				}
			} catch (IllegalStateException e) {
				System.out.println("ERROR! Caused by " + e.getMessage());// Handling possible exception
			}
		}
	}

	/*In the Query, the EventIterator and an auxiliary Map were used, it goes through the list of Events and stores it in the auxiliary, 
	 * after which a new EventIterator is created with the events of the Auxiliary Map.
	 *this new Event Iterator is returning, there is also an Exception handling for possible errors
	 */
	@Override
	public EventIterator query(String type, long startTime, long endTime) {
		@SuppressWarnings("resource")
		EventIterator iterator = new EventIteratorImplementation(eventArray);
		Map<String, Event> eventMapAux = new ConcurrentHashMap<>();
		while (iterator.moveNext()) {
			try {
				String[] aux = iterator.current().type().split(",");
				if (!type.equals(aux[0]) || iterator.current().timestamp() < startTime
						|| iterator.current().timestamp() >= endTime) {
					iterator.remove();
				} else {
					eventMapAux.put(type + "," + iterator.current().timestamp(), iterator.current());
				}
			} catch (IllegalStateException e) {
				System.out.println("ERROR! Caused by " + e.getMessage());
			}
		}
		return new EventIteratorImplementation(eventMapAux);
	}

//ToString to print event list
	@Override
	public String toString() {// ToString to print object EventStore
		return "EventStore: " + eventArray + "\nSize: " + eventArray.size();
	}
}
