import java.lang.reflect.Array;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    public NativeCache(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        hits = new int[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) //hash-функция
    {
        int hash = 0;
        int R = 17;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            hash = (hash*R + (int)key.charAt(i))%size;
        }
        return hash;
    }

    public void put(String key, T value)  // гарантированно записываем значение value по ключу key
    {
        int index = hashFun(key);

        if ((slots[index] != null) && (slots[index] != key))  //если слот занят, ищем свободный слот
            index = seekSlot(index,null);

        if (index == -1)                     //если свободных слотов нет, удаляем одни из них
            index = removeSlot();

        slots[index] = key;
        values[index] = value;
        hits[index]++;
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

    private int removeSlot(){ //нахождение слота с наименьшим количеством обращений
        int min = hits[0];
        int index = 0;
        for (int i = 1; i < size; i++) {
            if(hits[i]<min) {
                min = hits[i];
                index = i;
            }
        }
        hits[index] = 0;
        return index;
    }

    public T get(String key)  // возвращает value для key, или null если ключ не найден
    {
        int index = hashFun(key);

        if (slots[index] != key)
            index = seekSlot(index,key);

        if (index != -1){
            hits[index]++;
            return values[index];
        }
        return null;
    }

    public boolean isKey(String key)// возвращает true если ключ имеется, иначе false
    {
        int index = hashFun(key);

        if (slots[index] != key)
            index = seekSlot(index,key);

        if (index != -1) {
            hits[index]++;
            return true;
        }
        return false;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(i + " "+ slots[i] + " " +values[i] + " "+ hits[i]);
        }
    }
}