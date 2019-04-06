import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        int hash = 0;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            hash = (hash + (int)key.charAt(i))%size;
        }
        return hash;
    }

    public boolean isKey(String key)// возвращает true если ключ имеется, иначе false
    {
        int index = hashFun(key);

        if (slots[index] != key)
            index = seekSlot(index,key);

        if (index != -1)
            return true;

        return false;
    }

    public void put(String key, T value)  // гарантированно записываем значение value по ключу key
    {
        int index = hashFun(key);

        if ((slots[index] != null) && !(isKey(key)))
            index = seekSlot(index,null);

        if (index != -1) {
            slots[index] = key;
            values[index] = value;
        }
    }

    private int seekSlot(int index, String s){
        int count = 0;
        while (count < size) {
            index++;
            if (index == size)
                index = index - size;

            if (slots[index] == s)
                return index;
            count++;
        }
        return -1;
    }

    public T get(String key)  // возвращает value для key, или null если ключ не найден
    {
        int index = hashFun(key);

        if (slots[index] != key)
            index = seekSlot(index,key);

        if (index != -1)
            return values[index];

        return null;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(i + " "+ slots[i] + " " +values[i]);
        }
    }
}