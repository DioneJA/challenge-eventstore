/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeImp;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.intelie.challenges.Event;
import net.intelie.challenges.EventIterator;

/**
 *
 * @author bruno
 */
public class EventIteratorImplementation implements EventIterator {

    private Iterator<Entry<String, Event>> iterator;//An Iterator to traverse the Event Store
    private Map.Entry<String, Event> current;//Map.Entry to get the current Event, thus being able to access its value
    private int size;//Map size, for removal control
    public EventIteratorImplementation(Map<String, Event> event) {
    	if(event.size()>0) {
            this.iterator = event.entrySet().iterator();
            setSize(event.size());
    	}else {
    		throw new EventException("Error! Caused by Event Map is null");
    	}

    }
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
    @Override
    public boolean moveNext() {//Using the generic iterator to loop through events
        if (!iterator.hasNext()) {
            return false;
        } else {
            current = iterator.next();
            return true;
        }
    }

    @Override
    public Event current() {//using the Map.Entry helper to access the current
        if (current != null) {
            return current.getValue();
        } else {
            throw new IllegalStateException("There isnt current event");
        }

    }

    @Override
    public void remove() {//The map itself present in the auxiliary Iterator is removed
        iterator.remove();
    }

    @Override
    public void close() {
    }
}
