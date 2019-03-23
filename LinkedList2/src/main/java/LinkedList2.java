import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node temp = head;
        while (temp != null){
            if (temp.value == _value)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node temp = head;
        while (temp != null){
            if (temp.value == _value)
                nodes.add(temp);
            temp = temp.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = find(_value);  //находим узел с данным значением

        if (node == null)          //если удаляемого значения нет в списке или список пустой
            return false;

        if (head == tail)          //если в списке один элемент
        {
            head = null;
            tail = null;
            return true;
        }

        if (node == head)           //если удаляемое значение это head
        {
            head.next.prev = null;
            head = head.next;
            return true;
        }

        if (node == tail) {         //если удаляемое значение это tail
            tail = tail.prev;
            tail.next = null;
        }
        else{                       //если узел в середине
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return true;
    }

    public void removeAll(int _value)
    {
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
        tail.prev = head;
        head = null;
        tail = null;
    }

    public int count()
    {
        Node temp = head;
        int len = 0;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null){                                //вставить в начало
            if (head != null) {                                 //взависимости от,того пустой ли список
                _nodeToInsert.next = head;
                head.prev = _nodeToInsert;
            }
            else{
                tail = _nodeToInsert;
            }
            head = _nodeToInsert;
        }
        else {
            if (containValue(_nodeAfter.value))                //если узел существует
            {
                _nodeToInsert.prev = _nodeAfter;
                _nodeToInsert.next = _nodeAfter.next;

                if (_nodeAfter != tail)
                    _nodeAfter.next.prev = _nodeToInsert;
                _nodeAfter.next = _nodeToInsert;

                if (_nodeAfter == tail)                        //если вставили самым последним, то это теперь tail
                    tail = _nodeToInsert;
            }
        }
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
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}