import static org.junit.Assert.*;

public class StackTest {

    @org.junit.Test
    public void size() {
        Stack stack = new Stack();
        assertEquals(0,stack.size());
        stack.push("Привет");
        stack.push(100);
        assertEquals(2,stack.size());
    }

    @org.junit.Test
    public void pop() {
        Stack stack = new Stack();
        assertEquals(null,stack.pop());
        stack.push("Привет");
        stack.push(100);
        assertEquals(100,stack.pop());
        assertEquals("Привет",stack.peek());

    }

    @org.junit.Test
    public void push() {
        Stack stack = new Stack();
        assertEquals(null,stack.pop());
        stack.push("Привет");
        stack.push(1234);
        assertEquals(1234,stack.peek());
    }

    @org.junit.Test
    public void peek() {
        Stack stack = new Stack();
        assertEquals(null,stack.peek());
        stack.push("Привет");
        assertEquals("Привет",stack.peek());
    }
}