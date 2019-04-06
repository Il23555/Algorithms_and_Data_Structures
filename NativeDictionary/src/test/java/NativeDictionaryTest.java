import static org.junit.Assert.*;

public class NativeDictionaryTest {

    @org.junit.Test
    public void hashFun() {
        NativeDictionary<String> map = new NativeDictionary(13,String.class);
        assertEquals(12,map.hashFun("hello"));
    }

    @org.junit.Test
    public void isKey() {
        NativeDictionary<String> map = new NativeDictionary(7,String.class);
        map.put("one","ssss");
        map.put("two","nnn");
        map.put("three","ppp");
        map.put("four","lll");
        map.put("five","nmnm");
        assertTrue(map.isKey("five"));
        assertFalse(map.isKey("six"));
    }

    @org.junit.Test
    public void put() {
        NativeDictionary<String> map = new NativeDictionary(3,String.class);
        map.put("one","ssss");
        map.put("two","nnn");
        assertEquals("ssss",map.get("one"));

        map.put("one","kkkkk");
        map.put("otw","lol");
        assertEquals("nnn",map.get("two"));
        assertEquals("lol",map.get("otw"));
        assertEquals("kkkkk",map.get("one"));
    }

    @org.junit.Test
    public void get() {
        NativeDictionary<String> map = new NativeDictionary(3,String.class);
        map.put("one","ssss");
        map.put("two","nnn");
        map.put("three","yyyyy");
        assertEquals("ssss",map.get("one"));
        assertEquals("yyyyy",map.get("three"));
        assertEquals(null,map.get("five"));
    }
}