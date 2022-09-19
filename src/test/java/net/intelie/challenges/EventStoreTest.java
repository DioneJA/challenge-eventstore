/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.intelie.challenges;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

import CodeImp.EventException;
import CodeImp.EventStoreImplementation;

/**
 *
 * @author bruno
 */
public class EventStoreTest {
	@Test(expected = EventException.class)
	public void testInserctionOfEventFail(){
		final EventStoreImplementation evtS = new EventStoreImplementation();
		final Event evt = null;

		evtS.insert(evt);
	}
	@Test
	public void testInserctionOfEventSucess() {
		final EventStoreImplementation evtS = new EventStoreImplementation();
		final Event evt = new Event("A",1);
		evtS.insert(evt);
	}
	@Test(expected = EventException.class)
	public void testInserctionOfMapEventsFail() {
		final Map<String,Event> evtMap = new ConcurrentHashMap<>();
		@SuppressWarnings("unused")
		final EventStore evtS = new EventStoreImplementation(evtMap);
	}
	@Test
	public void testInserctionOfMapEventsSucess() {
		final Map<String,Event> evtMap = new ConcurrentHashMap<>();
		evtMap.put("A,1", new Event("A",1));
		@SuppressWarnings("unused")
		final EventStore evtS = new EventStoreImplementation(evtMap);
	}
	@Test(expected = EventException.class)
	public void removelAllFailTestFail() {
		final Map<String,Event> evtMap = new ConcurrentHashMap<>();
		final EventStore evtS = new EventStoreImplementation(evtMap);
		evtS.removeAll("A");
	}
	@Test
	public void removelAllFailTestSucess() {
		final Map<String,Event> evtMap = new ConcurrentHashMap<>();
		evtMap.put("A,1", new Event("A",1));
		final EventStore evtS = new EventStoreImplementation(evtMap);
		evtS.removeAll("A");
	}
	@Test(expected = EventException.class)
	public void testQueryFail() {
		final Map<String,Event> evtMap = new ConcurrentHashMap<>();
		final EventStore evtS = new EventStoreImplementation(evtMap);
		evtS.query("A", 1, 2);
	}
	@Test
	public void testQuerySucess() {
		final Map<String,Event> evtMap = new ConcurrentHashMap<>();
		evtMap.put("A,1", new Event("A",1));
		final EventStore evtS = new EventStoreImplementation(evtMap);
		evtS.query("A", 1, 2);
	}
}	
