import java.util.HashMap;
import java.util.Map;

public class PowerSet
{
    private HashMap<String,String> map;

    public PowerSet()
    {
        map = new HashMap<String, String>();
    }

    public int size()
    {
        return map.size();
    }


    public void put(String value)
    {
        if (!(map.containsKey(value)))
            map.put(value,value);

    }

    public boolean get(String value)
    {
        return map.containsKey(value);
    }

    public boolean remove(String value)
    {
        if (map.containsKey(value)) {
            map.remove(value);
            return true;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet set = new PowerSet();
        for (Map.Entry<String,String> pair :map.entrySet()){
            String key = pair.getKey();
            if (set2.get(key))
                set.put(key);
        }
        return set;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet set = new PowerSet();
        for (Map.Entry<String,String> pair : map.entrySet()){
            String key = pair.getKey();
            set.put(key);
        }
        for (Map.Entry<String,String> pair : set2.map.entrySet()){
            String key = pair.getKey();
            set.put(key);
        }
        return set;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet set = new PowerSet();
        for (Map.Entry<String,String> pair : map.entrySet()){
            String key = pair.getKey();
            set.put(key);
        }
        for (Map.Entry<String,String> pair : set2.map.entrySet()){
            String key = pair.getKey();
            if (set.get(key))
                set.remove(key);
        }
        return set;
    }

    public boolean isSubset(PowerSet set2) // возвращает true, если set2 есть подмножество текущего множества, иначе false
    {
        boolean flag = true;
        for (Map.Entry<String,String> pair :set2.map.entrySet()){
            String key = pair.getKey();
            if (!map.containsKey(key))
                flag = false;
        }
        return flag;
    }

    public void print(){
        for (Map.Entry<String,String> pair : map.entrySet()){
            String key = pair.getKey();
            System.out.print(key + " ");
        }
        System.out.println();
    }
}