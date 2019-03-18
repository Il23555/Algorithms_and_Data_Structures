import java.util.ArrayList;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }
    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node temp = head;
        while (temp != null){
            if (temp.value == _value)
                nodes.add(temp);
            temp = temp.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (!containValue(_value))
            return false;

        if (head == null)
            return true;

        if (head == tail){
            head = null;
            tail = null;
            return true;
        }

        if (head.value == _value)
            head = head.next;
        else{
            Node temp = head;
            while (temp != null){
                if (temp.next.value == _value){
                    if (temp.next == tail){
                        tail = temp;
                    }
                    temp.next = temp.next.next;
                    return true;
                }
                temp = temp.next;
            }
        }
        return true;
    }

    private boolean containValue(int _value){
        Node temp = head;
        while(temp != null){
            if (temp.value == _value)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        int count = 0;
        Node temp = head;
        while (temp != null){
            if (temp.value == _value)
                count++;
            temp = temp.next;
        }

        for (int i = 0; i < count;i++){
            remove(_value);
        }
    }

    public void clear()
    {
        head.next = tail;
        head = null;
        tail = null;
    }

    public int count() {
        int len = 0;
        Node temp = head;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null){
            _nodeToInsert.next = head;
            head = _nodeToInsert;
        }
        else{
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
        }

        if (_nodeAfter == tail)
            tail =_nodeToInsert;

    }

    public void printList(){
        Node node = head;
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class Node {
    public int value;
    public Node next;
    public Node(int _value) {
        value = _value;
        next = null;
    }
}
