<h1> Introduction</h1>
<p>This challenge was performed 100% in Java. Here will be a brief description of the implemented methods and usage instructions.</p>

<h2> Class: EventStoreImplementation </h2>
<p>In this class, I used a Synchronized ArrayList for thread safe. It has an empty constructor and one with the possibility of sending a list of events.</p>

<h3> Methods of EventStoreImplementation</h3>
<p><b>getEventArray():</b> Returns the eventArray event list.</p>
<p><b>Insert(): </b>Inserts one event at a time into the eventArray list. If it is not null.</p>
<p><b>RemoveAll(): </b>It traverses the list using an iterator within a synchronized block and removes all events of a given type, passed by parameter.</p>
<p><b>Query(): </b>It goes through the list and filters the events that fit the parameters using lambda expression, adding them to the EventIterator class.</p>

<h2> Class: EventIteratorImplementation</h2>
<p>In this class, I used a Synchronized ArrayList for thread safe.<p>
  
<h3> Methods of EventIteratorImplementation</h3>
<p><b>Insert(): </b>Inserts one event at a time into the filtredList list. If it is not null.</p>
<p><b>getFiltredList():</b> Returns the filtredList event list.</p>
<p><b>moveNext(): </b>The class uses a Position variable to know which position it is in at the moment, if this method is called the Position variable receives +1 and returns true. If the position reaches the size of the list, it returns false and does not add +1 to the variable.</p>
<p><b>current(): </b>Returns the current event based on the Position variable present in the class.</p>
<p><b>remove(): </b>Remove the current event based on the Position variable.</p>
<p><b>close(): </b>Clear the class.</p>

<h2>Main class: Program</h2>
<p>In this class some tests are performed using the classes that were implemented.</p>

<h2> No pacote TestPackages: Foram adicionadas duas classses de testes. </h2>
<h3> EventStoreTest: </h3>
<p> Here contains tests for all methods of the EventStoreImplmentation class.</p>
<h3>EventIteratorTest: </h3>
<p>Here contains tests for all methods of the EventIteratorImplementation class.</p>

<b>To test the program, just make changes to the main class or test classes.</b>