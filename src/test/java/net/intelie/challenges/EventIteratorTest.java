/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.intelie.challenges;

import implementation.EventIteratorImplementation;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author bruno
 */
public class EventIteratorTest {

    @Test
    public void insert() {
        EventIteratorImplementation evt = new EventIteratorImplementation();
        evt.insert(new Event("Type1", 1L));
        assertEquals(1, evt.getFiltredList().size());
    }

    @Test
    public void moveNext() {
        EventIteratorImplementation evt = new EventIteratorImplementation();
        assertEquals(false, evt.moveNext());

        evt.insert(new Event("Type1", 1L));
        assertEquals(true, evt.moveNext());
    }

    @Test
    public void current() {
        EventIteratorImplementation evt = new EventIteratorImplementation();

        evt.insert(new Event("Type1", 1L));
        evt.insert(new Event("Type2", 1L));
        evt.moveNext();
        assertEquals("Type1", evt.current().type());
        evt.moveNext();
        assertEquals("Type2", evt.current().type());
    }

    @Test
    public void remove() {
        EventIteratorImplementation evt = new EventIteratorImplementation();
        evt.insert(new Event("Type1", 1L));
        evt.insert(new Event("Type2", 1L));
        evt.moveNext();
        evt.moveNext();
        evt.remove();
        assertEquals(1, evt.getFiltredList().size());
        assertEquals("Type1", evt.current().type());
    }
}
