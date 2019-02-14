package model.data_structures;

import junit.framework.TestCase;

public class TestQueue extends TestCase{

	private Queue<String> queue;

	private void setupEscenario1() {
		queue = new Queue<String>();
		queue.enqueue("String 0");
		queue.enqueue("String 1");
		queue.enqueue("String 2");
		queue.enqueue("String 3");
	}
	
	private void setupEscenario2() {
		queue = new Queue<String>();
	}
	
	public void testEnqueue() {
		setupEscenario1();
		queue.enqueue("String 4");
		assertEquals(5, queue.size());
	}
	
	public void testEnqueue1() {
		setupEscenario2();
		queue.enqueue("String 0");
		assertEquals(1, queue.size());
	}
	
	public void testDequeue() {
		setupEscenario1();
		queue.dequeue();
		assertEquals(3, queue.size());
	}
	

	public void testDarElemento() {
		setupEscenario1();
		queue.dequeue();
		queue.dequeue();
		assertEquals("String 2", queue.dequeue());
	}

}
