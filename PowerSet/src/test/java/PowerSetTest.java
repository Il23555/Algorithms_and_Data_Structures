import static org.junit.Assert.*;

public class PowerSetTest {

    @org.junit.Test
    public void size() {
        PowerSet set = new PowerSet();
        assertEquals(0,set.size());
        set.put("kkkk");
        set.put("sss");
        set.put("al");
        assertEquals(3,set.size());
    }

    @org.junit.Test
    public void put() {
        PowerSet set = new PowerSet();
        set.put("one");
        set.put("two");
        set.put("three");
        assertEquals(3,set.size());
        set.put("one");
        assertEquals(3,set.size());
    }

    @org.junit.Test
    public void get() {
        PowerSet set = new PowerSet();
        set.put("one");
        set.put("two");
        assertTrue(set.get("one"));
        assertFalse(set.get("on"));
    }

    @org.junit.Test
    public void remove() {
        PowerSet set = new PowerSet();
        set.put("one");
        set.put("two");
        set.put("three");
        assertEquals(3,set.size());

        set.remove("one");
        assertFalse(set.get("one"));
        assertEquals(2,set.size());

        set.remove("ll");
        assertEquals(2,set.size());
    }

    @org.junit.Test
    public void intersection() {
        PowerSet set1 = new PowerSet();
        set1.put("one");
        set1.put("two");
        set1.put("three");
        set1.put("four");

        PowerSet set2 = new PowerSet();
        set2.put("three");
        set2.put("four");
        set2.put("five");
        set2.put("six");

        PowerSet set = set1.intersection(set2);
        assertEquals(2,set.size());

        PowerSet set3 = new PowerSet();
        set = set1.intersection(set3);
        assertEquals(0,set.size());

        PowerSet set4 = new PowerSet();
        set4.put("ooo");
        set4.put("ttt");
        set4.put("lll");
        set = set1.intersection(set4);
        assertEquals(0,set.size());
    }

    @org.junit.Test
    public void union() {
        PowerSet set1 = new PowerSet();
        set1.put("one");
        set1.put("two");
        set1.put("three");

        PowerSet set2 = new PowerSet();

        PowerSet set3 = set1.union(set2);
        assertEquals(3,set3.size());

        set2.put("four");
        set2.put("five");

        set3 = set1.union(set2);
        assertEquals(5,set3.size());
    }

    @org.junit.Test
    public void difference() {
        PowerSet set1 = new PowerSet();
        set1.put("one");
        set1.put("two");
        set1.put("three");
        set1.put("four");

        PowerSet set2 = new PowerSet();
        set2.put("four");
        set2.put("five");

        PowerSet set = set1.difference(set2);
        assertEquals(3,set.size());

        PowerSet set3 = new PowerSet();
        set = set1.difference(set3);
        assertEquals(4,set.size());
    }

    @org.junit.Test
    public void isSubset() {
        PowerSet set1 = new PowerSet();
        set1.put("one");
        set1.put("two");
        set1.put("three");
        set1.put("four");

        PowerSet set2 = new PowerSet();
        set2.put("one");
        set2.put("two");
        assertTrue(set1.isSubset(set2));

        PowerSet set3 = new PowerSet();
        set3.put("one");
        set3.put("two");
        set3.put("nnn");
        assertFalse(set1.isSubset(set3));

        PowerSet set4 = new PowerSet();
        set4.put("one");
        set4.put("two");
        set4.put("three");
        set4.put("four");
        set4.put("five");
        assertFalse(set1.isSubset(set4));
    }
}