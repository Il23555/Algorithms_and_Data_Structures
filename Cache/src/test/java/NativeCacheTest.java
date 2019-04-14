import static org.junit.Assert.*;

public class NativeCacheTest {

    @org.junit.Test
    public void put() {
        NativeCache<String> cache = new NativeCache<String>(4,String.class);
        cache.put("one","aaaaaa");
        cache.put("two","12345");
        cache.put("three","kkk");
        cache.put("four","nanana");
        assertTrue(cache.isKey("one"));
        assertTrue(cache.isKey("four"));
        assertEquals("kkk",cache.get("three"));
        cache.put("five","illlll");
        assertFalse(cache.isKey("two"));
    }

    @org.junit.Test
    public void get() {
        NativeCache<String> cache = new NativeCache<String>(5,String.class);
        cache.put("12345","llllll");
        cache.put("12445","kdkdkkk");
        assertEquals("llllll",cache.get("12345"));
        assertEquals("kdkdkkk",cache.get("12445"));
    }

}