import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LinkedListTest {

    @org.junit.Test
    public void addInTail(){
        LinkedList list = new LinkedList();
        Node node1 = new Node(4);
        list.addInTail(node1);
        assertEquals(node1,list.head);
        assertEquals(node1,list.tail);
        Node node2 = new Node(2);
        list.addInTail(node2);
        assertEquals(node2,list.tail);
    }
    @org.junit.Test
    public void find() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        list.addInTail(node1);
        list.addInTail(node2);
        assertEquals(null, list.find(3));
        assertEquals(node2,list.find(2));

    }

    @org.junit.Test
    public void findAll() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(4);
        list.addInTail(node1);
        Node node2 = new Node(3);
        list.addInTail(node2);
        Node node3 = new Node(5);
        list.addInTail(node3);
        Node node4 = new Node(2);
        list.addInTail(node4);
        ArrayList<Node> arr = new ArrayList<Node>();
        arr.add(node4);
        for(int i = 0; i < 3;i++){
            Node node = new Node(2);
            list.addInTail(node);
            arr.add(node);
        }
        assertEquals(arr, list.findAll(2));
    }

    @org.junit.Test
    public void remove() {
        LinkedList list = new LinkedList();
        Node node0 = new Node(1);
        list.addInTail(node0);
        list.remove(1);
        assertEquals(null,list.head);
        assertEquals(null,list.tail);

        Node node1 = new Node(2);
        list.addInTail(node1);
        Node node2 = new Node(4);
        list.addInTail(node2);
        Node node3 = new Node(3);
        list.addInTail(node3);
        Node node4 = new Node(5);
        list.addInTail(node4);

        list.remove(2);
        assertEquals(node2,list.head);
        list.remove(5);
        assertEquals(node3,list.tail);

        list.remove(3);
        assertEquals(null,node2.next);

        list.remove(1);
        assertEquals(node2,list.head);

    }

    @org.junit.Test
    public void removeAll() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(2);
        list.addInTail(node1);
        Node node2 = new Node(1);
        list.addInTail(node2);
        Node node3 = new Node(5);
        list.addInTail(node3);
        Node node4 = new Node(2);
        list.addInTail(node4);
        for (int i = 0; i < 3;i++){
            Node node = new Node(2);
            list.addInTail(node);
        }
        list.removeAll(2);

        assertEquals(node2,list.head);
        assertEquals(node3,list.tail);
    }

    @org.junit.Test
    public void clear() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(4);
        list.addInTail(node1);
        Node node2 = new Node(3);
        list.addInTail(node2);
        Node node3 = new Node(2);
        list.addInTail(node3);
        Node node4 = new Node(5);
        list.addInTail(node4);
        list.clear();
        assertEquals(null,list.head);
        assertEquals(null,list.tail);
        assertEquals(null,list.find(4));
        assertEquals(null,list.find(3));
        assertEquals(null,list.find(2));
        assertEquals(null,list.find(5));

    }

    @org.junit.Test
    public void count() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(4);
        list.addInTail(node1);
        Node node2 = new Node(3);
        list.addInTail(node2);
        Node node3 = new Node(2);
        list.addInTail(node3);
        Node node4 = new Node(5);
        list.addInTail(node4);
        assertEquals(4,list.count());
    }

    @org.junit.Test
    public void insertAfter() {
        LinkedList list = new LinkedList();
        Node node1 = new Node(2);
        list.insertAfter(null,node1);
        assertEquals(node1,list.head);
        assertEquals(node1,list.tail);
        Node node2 = new Node(4);
        list.addInTail(node2);
        Node node3 = new Node(3);
        list.insertAfter(node1,node3);
        Node node4 = new Node(5);
        list.insertAfter(node2,node4);
        Node node0 = new Node(1);
        list.insertAfter(null,node0);
        assertEquals(node0,list.head);
        assertEquals(node1,list.head.next);
        assertEquals(node3,node1.next);
        assertEquals(node4,list.tail);

    }
}