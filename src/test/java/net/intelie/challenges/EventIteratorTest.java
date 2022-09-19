/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.intelie.challenges;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import CodeImp.EventException;
import CodeImp.EventIteratorImplementation;
import CodeImp.EventStoreImplementation;

/**
 *
 * @author bruno
 */
public class EventIteratorTest {
	@Test(expected = EventException.class)
	public void testInserctionOfEventStoreFail() {
		final EventStoreImplementation evt = new EventStoreImplementation();
		@SuppressWarnings("unused")
		final EventIterator ectIt = new EventIteratorImplementation(evt.getEventArray());
	}
	@Test
	public void testInserctionOfEventStoreSucess() {
		final EventStoreImplementation evt = new EventStoreImplementation();
		evt.insert(new Event("A", 1));
		@SuppressWarnings("unused")
		final EventIterator ectIt = new EventIteratorImplementation(evt.getEventArray());
	}
	
	@Test
	public void testMoveNextFail() {
		final EventStoreImplementation evt = new EventStoreImplementation();
		evt.insert(new Event("A", 1));
		final EventIterator ectIt = new EventIteratorImplementation(evt.getEventArray());
		ectIt.moveNext();
		assertFalse(ectIt.moveNext());
	}
	@Test
	public void testMoveSucess() {
		final EventStoreImplementation evt = new EventStoreImplementation();
		evt.insert(new Event("A", 1));
		final EventIterator ectIt = new EventIteratorImplementation(evt.getEventArray());
		assertTrue(ectIt.moveNext());
	}
	@Test(expected = IllegalStateException.class)
	public void testCurrentFail() {
		final EventStoreImplementation evt = new EventStoreImplementation();
		evt.insert(new Event("A", 1));
		final EventIterator ectIt = new EventIteratorImplementation(evt.getEventArray());
		ectIt.moveNext();
		ectIt.moveNext();
		ectIt.current();
	}
	@Test
	public void testCurrentSucess() {
		final EventStoreImplementation evt = new EventStoreImplementation();
		evt.insert(new Event("A", 1));
		final EventIterator ectIt = new EventIteratorImplementation(evt.getEventArray());
		ectIt.moveNext();
		ectIt.current();
	}
	@Test
	public void testRemove() {
		final EventStoreImplementation evt = new EventStoreImplementation();
		evt.insert(new Event("A", 1));
		final EventIteratorImplementation ectIt = new EventIteratorImplementation(evt.getEventArray());
		final int size = ectIt.getSize();
		ectIt.moveNext();
		ectIt.remove();
		assertEquals(size - 1,ectIt.getSize());
	}
}
