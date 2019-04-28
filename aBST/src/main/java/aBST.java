import java.util.*;

class aBST
{
    public Integer Tree []; // массив ключей

    public aBST(int depth)
    {
        // правильно рассчитайте размер массива для дерева глубины depth:
        int tree_size = 1;
        int t = 1;
        for (int i = 1; i < depth +1 ; i++) {
            t = t*2;
            tree_size = tree_size + t;
        }
        Tree = new Integer[ tree_size ];
        for(int i=0; i<tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key)
    {
        int index = 0;
        while (Tree.length > index){
            if (Tree[index] == null){
                return key*(-1);
            }
            if (Tree[index] == key)
                return index;
            if (Tree[index] > key)
                index = 2*index+1;
            else
            if (Tree[index] < key)
                index = 2 * index + 2;
        }
        return null; // не найден
    }

    public int AddKey(int key)
    {
        int index = 0;
        while (Tree.length > index){
            if (Tree[index] == null){
                Tree[index] = key;
                return index;
            }
            if (Tree[index] == key)
                return index;
            if (Tree[index] > key)
                index = 2*index+1;
            else
                if (Tree[index] < key)
                    index = 2 * index + 2;

        }
        return -1;
        // индекс добавленного/существующего ключа или -1 если не удалось
    }

}