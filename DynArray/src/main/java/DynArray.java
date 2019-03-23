import java.awt.peer.SystemTrayPeer;
import java.lang.IndexOutOfBoundsException;
import java.lang.reflect.Array;

public class DynArray<T>   
{
    public T [] array;
    public int count;
    public int capacity;
    private Class<T> clazz;

    public DynArray(Class<T> clazz){
       this.clazz = clazz;
       count = 0;
       makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        T[] temp = (T[]) Array.newInstance(this.clazz,capacity); ;

        for (int i =0; i < count;i++) {         //сохраняем текущие значения массива во временный массив
            temp[i] = array[i];
        }

        array = (T[]) Array.newInstance(this.clazz, new_capacity);  //создаем новый массив и записываем все текущие значения

        for(int i = 0;i < count;i++){
            array[i] = temp[i];
        }

        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if ((index < count) && (index >=0)) //проверка индекса
            return array[index];
        else
            return  null;
    }


    public void append(T itm)
    {
        if (count == capacity){              //если массив заполнен
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }


    public void insert(T itm, int index) {

        if ((index > count) || (index < 0))  //проверка индекса
        {
            throw new IndexOutOfBoundsException("Попытка вставки элемента в недопустимую позицию");
        }

        if (count == capacity) {                            //если массив полностью заполнен
            makeArray(capacity * 2);
        }

        for (int i = count; i > index; i--) {              //смещение элементов
            array[i] = array[i - 1];
        }

        array[index] = itm;                                //вставка
        count++;

    }

    public void remove(int index) {
        if ((index >= count) || (index < 0))               //проверка индекса
        {
            throw new IndexOutOfBoundsException("Попытка удаления элемента в недопустимой позиции");
        }

        for (int i = index; i < (count - 1); i++) {        //удаление
            array[i] = array[i + 1];
        }
        count--;

        if (2 * count < capacity)
            if (capacity > 32)
                makeArray(((capacity * 2) / 3));
            else
                makeArray(16);

    }

}