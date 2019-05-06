import static org.junit.Assert.*;

public class HeapTest {

    @org.junit.Test
    public void makeHeap() {
        Heap heap = new Heap();
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        heap.MakeHeap(a,3);
        int i = 0;
        while(i < (heap.HeapArray.length)/2){
        assertTrue(heap.HeapArray[i] > heap.HeapArray[2*i+1] && heap.HeapArray[i] > heap.HeapArray[2*i+2]);
        i++;
        }

    }

    @org.junit.Test
    public void getMax() {
        Heap heap = new Heap();
        int[] a = new int[]{1};
        assertEquals(-1,heap.GetMax());
        heap.MakeHeap(a,0);
        assertEquals(1,heap.GetMax());
        assertEquals(-1,heap.GetMax());
    }

    @org.junit.Test
    public void add() {
        Heap heap = new Heap();
        int[] a = new int[]{1,2,3,4,5,6};
        heap.MakeHeap(a,2);
        assertTrue(heap.Add(7));
        int i = 0;
        while(i < (heap.HeapArray.length)/2){
            assertTrue(heap.HeapArray[i] > heap.HeapArray[2*i+1] && heap.HeapArray[i] > heap.HeapArray[2*i+2]);
            i++;
        }
        assertFalse(heap.Add(0));
    }
}