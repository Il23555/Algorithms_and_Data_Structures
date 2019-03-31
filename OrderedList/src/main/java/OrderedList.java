import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;
    private T val;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) //сравнение значений
    {
        if ((v1 instanceof Integer) && (v2 instanceof Integer)) {
            if ((Integer)v1 < (Integer) v2)
                return -1;
            if (v1 == v2)
                return 0;
            if ((Integer)v1 > (Integer)v2)
                return 1;
        }
        return 0;
    }

    public void add(T value)      //вставка элемента
    {   Node<T> node = new Node<T>(value);
        Node<T> nodeAfter = findNodeAfter(value); //находим связываемый узел

        if (nodeAfter == null){ //вставить в начало
            if (head != null) { //взависимости от,того пустой ли список
                node.next = head;
                head.prev = node;
            }
            else{
                tail = node;
            }
            head = node;
        }
        else {
            node.prev = nodeAfter;
            node.next = nodeAfter.next;

            if (nodeAfter != tail)
                nodeAfter.next.prev = node;
            nodeAfter.next = node;

            if (nodeAfter == tail) //если вставили самым последним, то это теперь tail
                tail = node;
        }
    }

    private Node<T> findNodeAfter(T val)
    {
        Node<T> temp = head;
        while (temp != null){
            int i = compare(temp.value,val);
            if (i == 0)
                return temp;
            if ((i == 1) && (_ascending))
                return temp.prev;
            if ((i == -1) && (!_ascending))
                return temp.prev;
            temp = temp.next;
        }
        return tail;
    }

    public Node<T> find(T val)  //поиск элемента
    {
        Node<T> temp = head;
        while (temp != null){
            int i = compare(temp.value,val);
            if (i == 0)
                return temp;
            if ((i == 1) && (_ascending))
                return null;
            if ((i == -1) && (!_ascending))
                return null;
            temp = temp.next;
        }
        return null;
    }

    public void delete(T val)   //удаление элемента
    {
        Node<T> node = find(val);  //находим узел с данным значением

        if (node != null)       //если удаляемое значения есть в списке и список не пустой
        {
            if (head == tail)   //если в списке один элемент
            {
                head = null;
                tail = null;
            }
            else {
                if (node == head)  //если удаляемое значение это head
                {
                    head.next.prev = null;
                    head = head.next;
                }
                else {
                    if (node == tail) {  //если удаляемое значение это tail
                        tail = tail.prev;
                        tail.next = null;

                    } else {      //если узел в середине
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                    }
                }
            }
        }
    }

    public void clear(boolean asc)  //очистить список
    {
        _ascending = asc;
        head.next = tail;
        tail.prev = head;
        head = null;
        tail = null;
    }

    public int count()   //подсчёт количества элементов в списке
    {
        Node<T> temp = head;
        int len = 0;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
