import static org.junit.Assert.*;

public class DynArrayTest {

    @org.junit.Test
    public void getItem() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        Integer a = 2;
        arr.append(1);
        arr.append(a);
        assertEquals(a, arr.getItem(1));
    }

    @org.junit.Test
    public void append() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 20; i++){
            Integer a = i;
            arr.append(a);
        }
        assertEquals(32,arr.capacity);
    }

    @org.junit.Test
    public void insert() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class); //вставка элемента когда, массив не заполнен полностью
        for (int i = 10; i < 20; i++){
            Integer a = i;
            arr.append(a);
        }
        arr.insert(9,0);
        assertEquals((Integer)9,arr.getItem(0));
        assertEquals((Integer)10,arr.getItem(1));
        assertEquals(16,arr.capacity);

        arr.insert(21,11);                        //вставка последним элементом
        assertEquals((Integer) 21, arr.getItem(11));

        arr.insert(23,14);                        //вставка в недопустимую позицию

        for(int i = 22; i < 26;i++){
            arr.append(i);
        }

        arr.insert(8,0);                         //вставка, когда массив переполнен
        assertEquals(32,arr.capacity);

    }

    @org.junit.Test
    public void remove() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class); //удаление элемента когда, массив не заполнен полностью
        for (int i = 5; i < 20; i++){
            Integer a = i;
            arr.append(a);
        }
        arr.remove(0);
        assertEquals((Integer)6,arr.getItem(0));
        assertEquals(16,arr.capacity);

       arr.remove(16);                        //удаление несуществующего индекса

        arr.append(21);                             //удаление, когда массив заполнен
        arr.append(22);
        arr.append(23);
        assertEquals(32,arr.capacity);

        arr.remove(0);
        arr.remove(1);
        assertEquals(16,arr.capacity);


    }
}