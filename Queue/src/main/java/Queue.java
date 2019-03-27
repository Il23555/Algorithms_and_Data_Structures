import java.util.*;

public class Queue<T>
{
    LinkedList<T> list;
    int count;

    public Queue()
    {
        list = new LinkedList<T>();
        count = 0;
    }

    public void enqueue(T item)
    {
        list.add(item);
        count++;
    }

    public T dequeue()
    {
        if (count != 0){
            T item = list.get(0);
            list.remove(0);
            count--;
            return item;
        }
        return null; // null если очередь пустая
    }

    public int size()
    {
        return count; // размер очереди
    }

}