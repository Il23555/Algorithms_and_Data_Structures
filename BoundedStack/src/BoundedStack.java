import java.lang.reflect.Array;

public class BoundedStack<T> {

    // скрытые поля
    private T[] stack; // основное хранилище стека
    private int peek_status; // статус запроса peek()
    private int pop_status; // статус команды pop()
    private int push_status; // статус команды push()
    private int max_size; // максимальный размер стека
    private int size;
    private Class<T> clazz;

    // интерфейс класса, реализующий АТД Stack
    private final int POP_NIL = 0;
    private final int POP_OK = 1;
    private final int POP_ERR = 2;
    private final int PEEK_NIL = 0;
    private final int PEEK_OK = 1;
    private final int PEEK_ERR = 2;
    private final int PUSH_NIL = 0;
    private final int PUSH_OK = 1;
    private final int PUSH_ERR = 2;

    // предусловие: задается целое положительное число
    // постусловие: создан новый пустой стек
    public BoundedStack(Class<T> clazz, int max_size) {
        if (max_size > 0)
            this.max_size = max_size;
        else
            this.max_size = 32;
        //создание пустого стека
        this.clazz = clazz;
        clear();
    }

    public BoundedStack(Class<T> clazz) {
        max_size = 32;
        //создание пустого стека
        this.clazz = clazz;
        clear();
    }

    // предусловие: стек не наполнен
    // постусловие: в стек добавлено новое значение
    public void push(T value) {
        if (size < max_size) {
            stack[size++] = value;
            push_status = PUSH_OK;
        }
        else
            push_status = PUSH_ERR;
    }

    // предусловие: стек не пустой;
    // постусловие: из стека удалён верхний элемент
    public void pop() {
        if (size > 0) {
            stack[size - 1] = null;
            size--;
            pop_status = POP_OK;
        } else
            pop_status = POP_ERR;
    }

    // постусловие: из стека удалятся все значения
    public void clear() {
        stack = (T[]) Array.newInstance(this.clazz, max_size);
        size = 0;
        // начальные статусы для предусловий
        peek_status = PEEK_NIL;
        pop_status = POP_NIL;
        push_status = PUSH_NIL;
    }

    // предусловие: стек не пустой
    public T peek() {
        T result = null;
        if (size > 0) {
          result = stack[size - 1];
          peek_status = PEEK_OK;
        }
        else
            peek_status = PEEK_ERR;

        return result;
    }

    public int size() {
        return size;
    }

    // запросы статусов
    public int get_pop_status(){
        return pop_status;
    }

    public int get_peek_status(){
        return peek_status;
    }

    public int get_push_status(){
        return push_status;
    }
}