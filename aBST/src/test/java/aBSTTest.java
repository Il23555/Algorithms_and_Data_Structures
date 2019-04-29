import static org.junit.Assert.*;

public class aBSTTest {

    @org.junit.Test
    public void findKeyIndex() {
        aBST tree = new aBST(2);
        assertEquals((Integer)(0),tree.FindKeyIndex(9));
        tree.AddKey(9);
        assertEquals((Integer)0,tree.FindKeyIndex(9));

        tree.AddKey(6);
        tree.AddKey(14);
        assertEquals((Integer)1,tree.FindKeyIndex(6));
        assertEquals((Integer)2,tree.FindKeyIndex(14));

        tree.AddKey(10);
        tree.AddKey(20);

        assertEquals((Integer)(-3),tree.FindKeyIndex(4));
        tree.AddKey(3);
        assertEquals(null,tree.FindKeyIndex(4));

        tree.AddKey(7);
        tree.AddKey(1);
        assertEquals(null,tree.FindKeyIndex(0));

    }

    @org.junit.Test
    public void addKey() {
        aBST tree = new aBST(2);
        assertEquals(0,tree.AddKey(9));
        assertEquals(1,tree.AddKey(6));
        assertEquals(2,tree.AddKey(14));
        assertEquals(5,tree.AddKey(10));

        for (int i = 0; i < tree.Tree.length; i++) {
            System.out.print(tree.Tree[i] + "  ");
        }
    }
}