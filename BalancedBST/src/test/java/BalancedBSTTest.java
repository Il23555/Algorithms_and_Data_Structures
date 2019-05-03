import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class BalancedBSTTest {

    @org.junit.Test
    public void createFromArray() {
        int[] a = new int[]{1,2,3,4,5,6,7};
        BalancedBST tree = new BalancedBST();
        tree.CreateFromArray(a);
        assertEquals(4,tree.BSTArray[0]);
        assertEquals(2,tree.BSTArray[1]);
        assertEquals(6,tree.BSTArray[2]);
    }

    @org.junit.Test
    public void generateTree() {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        BalancedBST tree = new BalancedBST();
        tree.CreateFromArray(a);
        tree.GenerateTree();
        Queue<BSTNode> queue = new LinkedList<BSTNode>();
        BSTNode temp = null;
        queue.offer(tree.Root);
        int i = 0;
        while(i != 3){
            temp = queue.poll();
            assertEquals(temp.NodeKey,tree.BSTArray[i]);
            if (temp.LeftChild != null)
                queue.offer(temp.LeftChild);
            if (temp.RightChild != null)
                queue.offer(temp.RightChild);
            i++;
        }
    }

    @org.junit.Test
    public void isBalanced() {
        BalancedBST tree = new BalancedBST();
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        tree.CreateFromArray(a);
        tree.GenerateTree();
        assertTrue(tree.IsBalanced(tree.Root));
    }
}