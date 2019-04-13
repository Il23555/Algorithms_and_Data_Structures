public class BloomFilter
{
    public int filter_len;
    public byte[] arr;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        arr = new byte[f_len];
    }

    // хэш-функции
    public int hash1(String str1)
    {
        int R =17;
        int hash = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            hash = (hash*R + code)%filter_len;
        }
        return hash;
    }
    public int hash2(String str1)
    {
        int R = 223;
        int hash = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            hash = (hash*R + code)%filter_len;
        }
        return hash;
    }

    public void add(String str1)
    {
        arr[hash1(str1)]++;
        arr[hash2(str1)]++;
    }

    public boolean isValue(String str1)
    {
        if ((arr[hash1(str1)] != 0) && (arr[hash2(str1)] != 0))
            return true;
        return false;
    }
}