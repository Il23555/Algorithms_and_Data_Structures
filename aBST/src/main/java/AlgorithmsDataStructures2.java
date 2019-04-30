import java.util.*;

import java.util.Arrays.*;

public class AlgorithmsDataStructures2
{
    public static int[] GenerateBBSTArray(int[] a)
    {
        Arrays.sort(a);
        //Создаем итоговой массив
        int c = (int) Math.pow(2,(int)(Math.log10(a.length)/Math.log10(2))+1) -1;
        int[] tree = new int[c];
        arr(tree,0,a,0,a.length-1);
        return tree;
    }

    private static int[] arr(int[] res,int index, int[] a,int l,int r){
        int m = (l+r)/2;
        res[index] = a[m];
        if (l != m)
            arr(res,2*index+1,a,l, m-1);
        if (m != r)
            arr(res,2*index+2,a,m+1, r);
        return res;
    }
}