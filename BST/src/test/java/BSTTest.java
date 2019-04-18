import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void findNodeByKey() {
        BSTNode<Integer> root = new BSTNode<Integer>(8,8,null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(root,tree.FindNodeByKey(8).Node);
        tree.AddKeyValue(12,12);
        tree.AddKeyValue(4,4);
        tree.AddKeyValue(6,6);
        assertTrue(tree.FindNodeByKey(6).NodeHasKey);
        assertFalse(tree.FindNodeByKey(9).NodeHasKey);
        assertTrue(tree.FindNodeByKey(9).ToLeft);
        assertFalse(tree.FindNodeByKey(7).NodeHasKey);
        assertFalse(tree.FindNodeByKey(7).ToLeft);
    }

    @Test
    public void addKeyValue() {
        BSTNode<Integer> root = new BSTNode<Integer>(8,8,null);
        BST<Integer> tree = new BST<Integer>(root);
        tree.AddKeyValue(12,12);
        tree.AddKeyValue(4,4);

        assertFalse(tree.FindNodeByKey(6).NodeHasKey);
        tree.AddKeyValue(6,6);
        assertTrue(tree.FindNodeByKey(6).NodeHasKey);
        assertEquals(tree.FindNodeByKey(6).Node,tree.FindNodeByKey(4).Node.RightChild);
        tree.AddKeyValue(9,9);
        assertEquals(tree.FindNodeByKey(9).Node,tree.FindNodeByKey(12).Node.LeftChild);
        tree.AddKeyValue(12,1234567);
        assertEquals((Integer)12,tree.FindNodeByKey(12).Node.NodeValue);
    }

    @Test
    public void finMinMax() {
        BSTNode<Integer> root = new BSTNode<Integer>(8,8,null);
        BST<Integer> tree = new BST<Integer>(root);
        tree.AddKeyValue(12,12);
        tree.AddKeyValue(4,4);
        tree.AddKeyValue(2,2);
        tree.AddKeyValue(9,9);
        assertEquals(2,tree.FinMinMax(root,false).NodeKey);
        assertEquals(12,tree.FinMinMax(root,true).NodeKey);
    }

    @Test
    public void deleteNodeByKey() {
        BSTNode<Integer> root = new BSTNode<Integer>(8,8,null);
        BST<Integer> tree = new BST<Integer>(root);
        tree.AddKeyValue(12,12);
        tree.AddKeyValue(4,4);
        tree.AddKeyValue(2,2);
        tree.AddKeyValue(10,10);
        tree.AddKeyValue(9,9);
        //удаление листа
        tree.DeleteNodeByKey(2);
        assertFalse(tree.FindNodeByKey(2).NodeHasKey);
        //удаление корня + общий случай
        tree.DeleteNodeByKey(8);
        assertFalse(tree.FindNodeByKey(8).NodeHasKey);
        assertEquals(tree.Root,tree.FindNodeByKey(9).Node);
        //удаление узла без правого потомка
        tree.DeleteNodeByKey(12);
        assertFalse(tree.FindNodeByKey(12).NodeHasKey);
        //удаление узла с одним правым потомком
        tree.AddKeyValue(13,13);
        tree.AddKeyValue(11,11);
        tree.AddKeyValue(14,14);
        tree.DeleteNodeByKey(13);
        assertFalse(tree.FindNodeByKey(13).NodeHasKey);
    }

    @Test
    public void count() {
        BSTNode<Integer> root = new BSTNode<Integer>(8,8,null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1,tree.Count());
        tree.AddKeyValue(12,12);
        tree.AddKeyValue(4,4);
        tree.AddKeyValue(2,2);
        tree.AddKeyValue(9,9);
        assertEquals(5,tree.Count());

    }
}