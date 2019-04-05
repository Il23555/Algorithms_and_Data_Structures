import static org.junit.Assert.*;

public class HashTableTest {

    @org.junit.Test
    public void hashFun() {
        HashTable hashTable = new HashTable(15,2);
        assertEquals(11, hashTable.hashFun("it"));
        assertEquals(10,hashTable.hashFun("is"));
        assertEquals(14,hashTable.hashFun("easy"));
    }

    @org.junit.Test
    public void seekSlot() {
        HashTable hashTable = new HashTable(5,2);
        assertEquals(4,hashTable.seekSlot("hi"));
        hashTable.put("just");
        hashTable.put("kidding");
        hashTable.put("hi");
        assertEquals(2,hashTable.seekSlot("llll"));
        assertEquals(2,hashTable.seekSlot("sweet"));
        hashTable.put("sweet");
        hashTable.put("llll");
        assertEquals(-1,hashTable.seekSlot("pumpmp"));
    }

    @org.junit.Test
    public void put() {
        HashTable hashTable = new HashTable(3,2);
        hashTable.put("hi");
        hashTable.put("yo");
        hashTable.put("klj");
        assertEquals(1,hashTable.find("yo"));
        assertEquals(2,hashTable.find("hi"));
        assertEquals(-1,hashTable.put("end"));
    }

    @org.junit.Test
    public void find() {
        HashTable hashTable = new HashTable(7,2);
        hashTable.put("hi");
        hashTable.put("fo");
        hashTable.put("klj");
        assertEquals(3,hashTable.find("fo"));
        assertEquals(6,hashTable.find("hi"));
        assertEquals(-1,hashTable.find("of"));
    }
}