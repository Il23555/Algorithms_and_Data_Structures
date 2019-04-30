import org.junit.Test;

import java.lang.reflect.GenericArrayType;

import static org.junit.Assert.*;

public class AlgorithmsDataStructures2Test {

    @Test
    public void generateBBSTArray() {
        int[] a = new int[]{1,2,3,4,5,6,7};
        int[] b = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        assertEquals(4,b[0]);
        assertEquals(6,b[2]);
        assertEquals(2,b[1]);
        assertEquals(1,b[3]);
    }
}