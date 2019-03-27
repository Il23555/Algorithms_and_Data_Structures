import static org.junit.Assert.*;

public class QueueTest {

    @org.junit.Test
    public void enqueue() {
        Queue queue = new Queue();
        queue.enqueue("Привет");
        queue.enqueue(1);
        assertEquals("Привет",queue.dequeue());
        assertEquals(1,queue.dequeue());
    }

    @org.junit.Test
    public void dequeue() {
        Queue queue = new Queue();
        assertEquals(null,queue.dequeue());
        queue.enqueue(1);
        assertEquals(1,queue.dequeue());
    }

    @org.junit.Test
    public void size() {
        Queue queue = new Queue();
        assertEquals(0,queue.size());
        queue.enqueue("ллллллл");
        assertEquals(1,queue.size());
    }
}