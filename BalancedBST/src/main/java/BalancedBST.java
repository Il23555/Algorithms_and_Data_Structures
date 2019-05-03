import java.util.*;

class BSTNode
{
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int     Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST
{
    public BSTNode Root;

    public int [] BSTArray; // временный массив для ключей дерева

    public BalancedBST()
    {
        Root = null;
    }

    public void CreateFromArray(int[] a) // создаём массив дерева BSTArray из заданного
    {
        Arrays.sort(a);
        int c = (int) Math.pow(2,(int)(Math.log10(a.length)/Math.log10(2))+1) -1;
        BSTArray = new int[c];
        arrBST(BSTArray,0,a,0,a.length-1);
    }

    private int[] arrBST(int[] res,int index, int[] a, int l, int r){
        int m = (l+r)/2;
        res[index] = a[m];
        if (l != m)
            arrBST(res,2*index+1,a,l, m-1);
        if (m != r)
            arrBST(res,2*index+2,a,m+1, r);
        return res;
    }

    public void GenerateTree()// создаём дерево с нуля из массива BSTArray
    {
        Root = new BSTNode(BSTArray[0],null);
        Root.Level = 0;
        if (BSTArray.length != 1)
            treeByNode(Root,0);
    }

    private void treeByNode(BSTNode Node,int index){
        BSTNode LeftChild = new BSTNode(BSTArray[2*index+1],null);
        BSTNode RightChild = new BSTNode(BSTArray[2*index+2],null);

        //если узлы есть
        if (LeftChild.NodeKey != 0){
            Node.LeftChild = LeftChild;
            LeftChild.Parent = Node;
            LeftChild.Level = Node.Level + 1;
            if(2*(2*index+1)+1 < BSTArray.length)
                treeByNode(LeftChild,2*index+1);
        }

        if (RightChild.NodeKey != 0) {
            Node.RightChild = RightChild;
            RightChild.Parent = Node;
            RightChild.Level = Node.Level + 1;
            if (2*(2*index+2)+2 < BSTArray.length)
                treeByNode(RightChild,2*index+2);
        }
    }


    public boolean IsBalanced(BSTNode root_node) // сбалансировано ли дерево с корнем root_node
    {
        return (checkBalance(root_node) != -1);
    }

    private int checkBalance(BSTNode Node){
        if (Node == null)
            return 0;
        int left = checkBalance(Node.LeftChild);
        int right = checkBalance(Node.RightChild);

        if ((right == -1) || (left == -1))
            return -1;

        if (((left - right) > 1) || ((left - right) < -1)){
            return -1;}

        return Math.max(left,right) + 1;
    }
}