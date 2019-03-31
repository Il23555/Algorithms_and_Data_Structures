import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderedListTest {

    @org.junit.Test
    public void add() {
        OrderedList list = new OrderedList(true);
        list.add(1);                            //добавление в пустой список
        assertEquals(1,list.head.value);
        assertEquals(1,list.tail.value);
        list.add(3);
        assertEquals(3,list.tail.value);
        list.add(2);
        assertEquals(2,list.head.next.value); //добавили в середину
        list.add(4);
        assertEquals(4,list.tail.value);      //добавили в конец
        list.add(0);
        assertEquals(0,list.head.value);      //добавили в начало
    }

    @org.junit.Test
    public void find() {
        OrderedList list = new OrderedList(true);
        assertEquals(null,list.find(2));  //поиск в пустом списке

        list.add(1);
        assertEquals(list.head,list.find(1));
        assertEquals(list.tail,list.find(1));
        list.add(0);
        assertEquals(list.head,list.find(0));
        list.add(3);
        assertEquals(list.tail,list.find(3));
        list.add(2);
        assertEquals(list.tail.prev,list.find(2));
    }

    @org.junit.Test
    public void delete() {
        OrderedList list = new OrderedList(true);
        list.delete(1);    //удаление в пустом списке
        list.add(100);
        list.delete(100);  //удаление единственного элемента
        assertEquals(null,list.head);
        assertEquals(null,list.tail);

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.delete(0);  //удаление head
        assertEquals(1,list.head.value);
        assertEquals(null,list.head.prev);

        list.delete(4);  //удаление tail
        assertEquals(3,list.tail.value);
        assertEquals(null,list.tail.next);

        list.delete(2);  //удаление в середине
        assertEquals(3,list.head.next.value);
        assertEquals(1,list.tail.prev.value);

        list.delete(3);
        assertEquals(1,list.head.value);
        assertEquals(1,list.tail.value);

    }

    @org.junit.Test
    public void clear() {
        OrderedList list = new OrderedList(true);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.clear(false);
        assertEquals(null,list.head);
        assertEquals(null,list.tail);
        assertEquals(null,list.find(1));
        assertEquals(null,list.find(2));
        assertEquals(null,list.find(3));
        assertEquals(null,list.find(4));
    }

    @org.junit.Test
    public void count() {
        OrderedList list = new OrderedList(true);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        assertEquals(5,list.count());

    }

}