/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.intelie.challenges;

import implementation.EventIteratorImplementation;
import implementation.EventStoreImplementation;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author bruno
 */
public class EventStoreTest {

    @Test
    public void insert() {
        EventStoreImplementation evt = new EventStoreImplementation();
        evt.insert(new Event("Type1", 1L));
        assertEquals("Type1", evt.getEventArray().get(0).type());
        assertEquals(1L, evt.getEventArray().get(0).timestamp());
    }

    @Test
    public void removeAll() {
        EventStoreImplementation evt = new EventStoreImplementation();
        evt.insert(new Event("Type1", 1L));
        evt.insert(new Event("Type1", 2L));
        evt.insert(new Event("Type2", 1L));
        evt.insert(new Event("Type3", 1L));
        evt.insert(new Event("Type4", 1L));

        evt.removeAll("Type1");

        assertEquals(3, evt.getEventArray().size());
    }

    @Test
    public void query() {
        EventStoreImplementation evt = new EventStoreImplementation();
        evt.insert(new Event("Type1", 1L));//Ok
        evt.insert(new Event("Type1", 2L));//Ok
        evt.insert(new Event("Type2", 1L));
        evt.insert(new Event("Type3", 1L));
        evt.insert(new Event("Type1", 3L));
        evt.insert(new Event("Type4", 1L));

        EventIteratorImplementation evtIterator = (EventIteratorImplementation) evt.query("Type1", 1, 3);
        assertEquals(2, evtIterator.getFiltredList().size());
        assertEquals("Type1", evtIterator.getFiltredList().get(0).type());
        assertEquals(1L, evtIterator.getFiltredList().get(0).timestamp());
        assertEquals("Type1", evtIterator.getFiltredList().get(1).type());
        assertEquals(2L, evtIterator.getFiltredList().get(1).timestamp());
    }
}
