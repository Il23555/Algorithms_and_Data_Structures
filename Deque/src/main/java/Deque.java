import java.util.*;

public class Deque<T>
{
    LinkedList<T> list;
    int count;

    public Deque()
    {
        list = new LinkedList<T>();
        count = 0;
    }

    public void addFront(T item)
    {
        list.add(0,item);
        count++;
    }

    public void addTail(T item)
    {
        list.add(item);
        count++;
    }

    public T removeFront()
    {
        if (count != 0){
            T item = list.get(0);
            list.remove(0);
            count--;
            return item;
        }
        return null;
    }

    public T removeTail()
    {
        if (count != 0){
            T item = list.get(count - 1);
            list.remove(count -1);
            count--;
            return item;
        }
        return null;
    }

    public int size()
    {
        return count; // размер очереди
    }
}