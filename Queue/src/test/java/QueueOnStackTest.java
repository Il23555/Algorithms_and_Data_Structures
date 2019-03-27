import org.junit.Test;

import static org.junit.Assert.*;

public class QueueOnStackTest {

    @Test
    public void enqueue() {
        QueueOnStack queue = new QueueOnStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1,queue.dequeue());
        assertEquals(2,queue.dequeue());
        assertEquals(3,queue.dequeue());
    }

    @Test
    public void dequeue() {
        QueueOnStack queue = new QueueOnStack();
        assertEquals(null,queue.dequeue());
        //queue.enqueue(1);
        //assertEquals(1,queue.dequeue());
    }

    @Test
    public void size() {
        QueueOnStack queue = new QueueOnStack();
        assertEquals(0,queue.size());
        queue.enqueue("ллллллл");
        assertEquals(1,queue.size());
    }
}