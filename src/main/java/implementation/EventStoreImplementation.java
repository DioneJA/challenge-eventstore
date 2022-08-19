/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.intelie.challenges.Event;
import net.intelie.challenges.EventIterator;
import net.intelie.challenges.EventStore;

/**
 *
 * @author bruno
 */
public class EventStoreImplementation implements EventStore {

    private final List<Event> eventArray = Collections.synchronizedList(new ArrayList<>()); //Make in syncronizedList for Thread Safe

    //Constructor's
    public EventStoreImplementation(List eventList) {
        eventArray.addAll(eventList);
    }

    public EventStoreImplementation() {
    }

    //getter's
    public List<Event> getEventArray() {
        return eventArray;
    }

    @Override
    public void insert(Event event) {
        if (event != null) {//Checking if any object event is null
            eventArray.add(event);// adding event in to ArrayList
        } else {
            return;
        }
    }

    @Override
    public void removeAll(String type) { //Cycling through the event arraylist and removing events of a type
        Iterator itr = eventArray.iterator();
        while (itr.hasNext()) {//traversing with iterator
            Event evt = (Event) itr.next();
            if (evt.type().equals(type)) {
                itr.remove();
            }
        }

    }

    @Override
    public EventIterator query(String type, long startTime, long endTime) {//The EventIterator object performs the filtering on a list and returns
        /* @param type} and timestamp between
        * @param startTime} (inclusive) and 
        * @param endTime} (exclusive)
        * @param getEventArray().*/

        EventIteratorImplementation evtImp = new EventIteratorImplementation();
        getEventArray().stream().filter(x -> (x.type().equals(type) && x.timestamp() >= startTime && x.timestamp() < endTime)).forEachOrdered(x -> {
            evtImp.insert(x);
        });
        return evtImp;

    }

    @Override
    public String toString() {// ToString to print object EventStore
        return "EventStore: " + eventArray;
    }

}
