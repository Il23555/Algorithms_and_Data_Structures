import java.util.*;

public class Stack<T>
{
    LinkedList<T> list;
    int count;

    public Stack()
    {
        list = new LinkedList<T>();
        count = 0;
    }

    public int size()
    {
        return count;
    }

    public T pop() {
        if (count != 0) {
            T val =  list.get(0);
            list.remove(0);
            count--;
            return val;
        }

        return null;  // если стек пустой
    }

    public void push(T val)
    {
        list.add(0,val);
        count++;
    }

    public T peek()
    {   if (count != 0) {
            T val =  list.get(0);
            return val;
            }
        return null; // если стек пустой
    }
}