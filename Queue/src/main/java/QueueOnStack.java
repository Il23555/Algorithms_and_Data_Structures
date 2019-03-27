import java.util.Stack;

public class QueueOnStack<T> {
    Stack<T> stack;
    int count;

    public QueueOnStack()
    {
        stack = new Stack<T>();
        count = 0;
    }

    public void enqueue(T item)
    {
        stack.push(item);
        count++;
    }

    public T dequeue()
    {   if (count == 0)
            return null; // null если очередь пустая

        Stack<T> temp = new Stack<T>();

        while (stack.size() != 0){
            T t = stack.pop();
            temp.push(t);
        }

        T item = temp.pop();
        count--;

        while (temp.size() != 0){
            T t = temp.pop();
            stack.push(t);
        }

        return item;
    }

    public int size()
    {
        return count;// размер очереди
    }
}
