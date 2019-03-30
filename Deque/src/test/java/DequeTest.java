import static org.junit.Assert.*;

public class DequeTest {

    @org.junit.Test
    public void addFront() {
        Deque deque = new Deque();
        deque.addFront("start");
        for(int i = 0; i < 4; i++){
            deque.addFront(i);
        }
        assertEquals("start",deque.removeTail());
        assertEquals(3,deque.removeFront());
    }

    @org.junit.Test
    public void addTail() {
        Deque deque = new Deque();
        deque.addFront("start");
        for(int i = 0; i < 4; i++){
            deque.addTail(i);
        }
        assertEquals("start",deque.removeFront());
        assertEquals(3,deque.removeTail());
        assertEquals(2,deque.removeTail());
    }

    @org.junit.Test
    public void removeFront() {
        Deque deque = new Deque();
        deque.addFront("start");
        deque.addFront("00");
        deque.addTail(12345);
        assertEquals("00",deque.removeFront());
        assertEquals("start",deque.removeFront());
        assertEquals(12345,deque.removeFront());
        assertEquals(null,deque.removeFront());
    }

    @org.junit.Test
    public void removeTail() {
        Deque deque = new Deque();
        deque.addFront("start");
        deque.addFront("00");
        deque.addTail(12345);
        assertEquals(12345,deque.removeTail());
        assertEquals("start",deque.removeTail());
        assertEquals("00",deque.removeTail());
        assertEquals(null,deque.removeTail());
    }

    @org.junit.Test
    public void size() {
        Deque deque = new Deque();
        assertEquals(0,deque.size());
        deque.addFront(1);
        assertEquals(1,deque.size());
    }
}