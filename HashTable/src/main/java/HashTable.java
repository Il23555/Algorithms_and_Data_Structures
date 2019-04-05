import java.sql.SQLOutput;

public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int hash = 0;
        int len = value.length();
        for (int i = 0; i < len; i++) {
            hash = (hash + (int)value.charAt(i))%size;
        }
        return hash;
    }

    public int seekSlot(String value) // находит индекс пустого слота для значения, или -1
    {
        int index = hashFun(value);

        if (slots[index] == null)
            return index;

        else {
            int count = 0;
            while (count < size){
                if (index+step >= size)
                    index = index+step - size;
                else
                    index+=step;
                if (slots[index] == null)
                    return index;
                count++;
            }
        }

        return -1;
    }

    public int put(String value) // записываем значение,или возвращается индекс слота или -1, если из-за коллизий элемент не удаётся разместить
    {
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            return index;
        }
        return -1;
    }

    public int find(String value) // находит индекс слота со значением, или -1
    {
        int index = hashFun(value);

        if (slots[index] == value)
            return index;
        else {
            int count = 0;
            while (count < size){
                if (index+step >= size)
                    index = index+step - size;
                else
                    index+=step;
                if (slots[index] == value)
                    return index;
                count++;
            }
        }

        return -1;
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(i + " "+ slots[i]);
        }
    }

}
