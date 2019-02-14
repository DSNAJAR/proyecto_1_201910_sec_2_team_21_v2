package model.data_structures;

import junit.framework.TestCase;

public class TestStack extends TestCase {
	private Stack<String> stack;

	private void setupEscenario1() {
		stack = new Stack<String>();
		stack.push("String 0");
		stack.push("String 1");
		stack.push("String 2");
		stack.push("String 3");
	}
	
	private void setupEscenario2() {
		stack = new Stack<String>();
	}
	
	public void testPush() {
		setupEscenario1();
		stack.push("String 4");
		assertEquals(5, stack.size());
	}
	
	public void testPush1() {
		setupEscenario2();
		stack.push("String 1");
		assertEquals(1, stack.size());
	}
	
	public void testPush2() {
		setupEscenario2();
		stack.push("String 1");
		stack.push("String 2");
		stack.push("String 3");

		assertEquals("String 3", stack.pop());
		assertEquals("String 2", stack.pop());
	}
	
	public void testPop() {
		setupEscenario1();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(true, stack.isEmpty());
	}
	
	public void testPop1() {
		setupEscenario1();
		assertEquals("String 3", stack.pop());
	}
	
	public void testPop2() {
		setupEscenario1();
		stack.push("String 4");
		assertEquals("String 4", stack.pop());
	}
	
	public void testSize() {
		setupEscenario2();
		assertEquals(0, stack.size());
	}
	
	public void testIsEmpty() {
		setupEscenario1();
		assertEquals(false, stack.isEmpty());
	}
}
