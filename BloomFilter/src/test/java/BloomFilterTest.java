import static org.junit.Assert.*;

public class BloomFilterTest {

    @org.junit.Test
    public void add() {
        BloomFilter filter = new BloomFilter(15);
        filter.add("0123456789");
        filter.add("1234567890");
        assertTrue(filter.isValue("1234567890"));
        assertTrue(filter.isValue("0123456789"));
    }

    @org.junit.Test
    public void isValue() {
        BloomFilter filter = new BloomFilter(15);
        filter.add("0123456789");
        filter.add("1234567890");
        assertTrue(filter.isValue("1234567890"));
        assertTrue(filter.isValue("0123456789"));
        assertFalse(filter.isValue("123456789"));
    }
}