/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import implementation.EventIteratorImplementation;
import net.intelie.challenges.Event;
import implementation.EventStoreImplementation;
import net.intelie.challenges.EventIterator;
import net.intelie.challenges.EventStore;

/**
 *
 * @author bruno
 */
public class Program {

    public static void main(String[] args) {

        EventStoreImplementation evtI = new EventStoreImplementation();//Declaring object of class EventStoreImplementation

        //Inserting objects Events in object evtI
        evtI.insert(new Event("A", 1));
        evtI.insert(new Event("AC", 4));
        evtI.insert(new Event("B", 7));
        evtI.insert(new Event("A", 3));
        evtI.insert(new Event("A", 5));
        evtI.insert(new Event("F", 2));
        evtI.insert(new Event("F", 78));
        evtI.insert(new Event("A", 2));
        System.out.println("EventStore: \n" + evtI); //Printing all objects Events in evtI

        evtI.removeAll("AC");//Removing objects of type "AC"
        System.out.println("\n\nEventStore after delete all 'AC' Type's: \n" + evtI);//Printing all objects Events in evtI after delete

        EventIteratorImplementation evtII = (EventIteratorImplementation) evtI.query("A", 1, 3);//Filtering objects with type 'A', StartTime: 1 and EndTime: 3
        System.out.println("\n\nPrinting all object in EventIterator after filter: ");
        while (evtII.moveNext()) {//Printing object EventIterator after fillter
            System.out.println(evtII.current());

        }
    }
}
