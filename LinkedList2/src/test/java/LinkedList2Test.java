import java.util.ArrayList;

import static org.junit.Assert.*;

public class LinkedList2Test {

    @org.junit.Test
    public void addInTail() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(1);
        list.addInTail(node1);
        assertEquals(node1,list.head);
        assertEquals(node1,list.tail);

        Node node2 = new Node(2);
        list.addInTail(node2);
        assertEquals(node2,list.tail);
        assertEquals(node2,list.head.next);
        assertEquals(node1,list.tail.prev);

        Node node3 = new Node(2);
        list.addInTail(node3);
        assertEquals(node3,list.tail);
        assertEquals(node2,list.tail.prev);
    }

    @org.junit.Test
    public void find() {
        LinkedList2 list = new LinkedList2();
        assertEquals(null, list.find(3));

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        list.addInTail(node1);
        list.addInTail(node2);

        assertEquals(null, list.find(3));
        assertEquals(node2,list.find(2));
    }

    @org.junit.Test
    public void findAll() {
        LinkedList2 list = new LinkedList2();
        ArrayList<Node> arr = new ArrayList<Node>();
        assertEquals(arr, list.findAll(2));

        Node node1 = new Node(2);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        arr.add(node1);
        arr.add(node2);
        for(int i = 0; i < 3;i++){
            Node node = new Node(2);
            list.addInTail(node);
            arr.add(node);
        }
        assertEquals(arr, list.findAll(2));

    }

    @org.junit.Test
    public void remove() {
        LinkedList2 list = new LinkedList2();
        assertFalse(list.remove(1));   //удаление в пустом списке

        Node node0 = new Node(1);
        list.addInTail(node0);
        list.remove(1);               //удаление единственного элемента
        assertEquals(null,list.head);
        assertEquals(null,list.tail);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);
        list.addInTail(node5);

        list.remove(1);                 //удаление head
        assertEquals(node2,list.head);
        assertEquals(null,list.head.prev);

        list.remove(5);                //удаление tail
        assertEquals(node4,list.tail);
        assertEquals(null,list.tail.next);

        list.remove(3);               //удаление в середине
        assertEquals(node4,node2.next);
        assertEquals(node2,node4.prev);

        list.remove(2);
        assertEquals(node4,list.head);
        assertEquals(node4,list.tail);

    }

    @org.junit.Test
    public void removeAll() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);

        for (int i = 0; i < 3;i++){
            Node node = new Node(2);
            list.addInTail(node);
        }
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(2);
        list.addInTail(node4);
        list.addInTail(node5);
        list.addInTail(node6);

        list.removeAll(2);

        assertEquals(node2,list.head);
        assertEquals(node5,list.tail);
        assertEquals(node4, node3.next);
        assertEquals(node3,node4.prev);

    }

    @org.junit.Test
    public void clear() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        list.clear();
        assertEquals(null,list.head);
        assertEquals(null,list.tail);
        assertEquals(null,list.find(1));
        assertEquals(null,list.find(2));
        assertEquals(null,list.find(3));
        assertEquals(null,list.find(4));

    }

    @org.junit.Test
    public void count() {
        LinkedList2 list = new LinkedList2();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        list.addInTail(node1);
        list.addInTail(node2);
        list.addInTail(node3);
        list.addInTail(node4);

        assertEquals(4,list.count());
    }

    @org.junit.Test
    public void insertAfter() {
        LinkedList2 list = new LinkedList2();

        Node node1 = new Node(1);
        list.insertAfter(null,node1);      //добавить в пустой список
        assertEquals(node1,list.head);
        assertEquals(node1,list.tail);

        Node node4 = new Node(4);
        list.addInTail(node4);

        Node node3 = new Node(3);            //добавили в середину
        list.insertAfter(node1,node3);
        assertEquals(node1,node3.prev);
        assertEquals(node3,node1.next);
        assertEquals(node3,node4.prev);
        assertEquals(node4,node3.next);


        Node node5 = new Node(5);           //добавили в конец
        list.insertAfter(node4,node5);
        assertEquals(node5,node4.next);
        assertEquals(node4,node5.prev);
        assertEquals(node5,list.tail);
        assertEquals(null,node5.next);
        assertEquals(node4,list.tail.prev);

        Node node0 = new Node(0);          //добавили в начало
        list.insertAfter(null,node0);
        assertEquals(node0,list.head);
        assertEquals(node1,list.head.next);
        assertEquals(list.head,node1.prev);
    }
}