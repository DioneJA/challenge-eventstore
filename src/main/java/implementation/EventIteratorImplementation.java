/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.intelie.challenges.Event;
import net.intelie.challenges.EventIterator;

/**
 *
 * @author bruno
 */
public class EventIteratorImplementation implements EventIterator {

    private final List<Event> filtredList = Collections.synchronizedList(new ArrayList<>());//Thread safe

    private int position = -1;

    //Constructors
    //filtering objects based on parameters and storing in filteredList, Lambda
    public EventIteratorImplementation() {
    }

    public List<Event> getFiltredList() {
        return filtredList;
    }

    public void insert(Event evt) {
        filtredList.add(evt);
    }

    @Override
    public boolean moveNext() {//Moving to the next position if this is not the last one
        if (position == filtredList.size() - 1) {
            return false;
        } else {
            position++;
            return true;
        }
    }

    @Override
    public Event current() {//Printing the current object if it exists
        if (position <= filtredList.size() - 1 && position >= 0) {
            return (Event) filtredList.get(position);
        } else {
            throw new IllegalStateException();
        }

    }

    @Override
    public void remove() {//Removing the current event, the position decreases to control the next events
        filtredList.remove(current());
        position--;
    }

    @Override
    public void close() throws Exception {
    }

    @Override
    public String toString() {//ToString to print object EventIterator
        return "Iterator: " + filtredList;
    }
}
