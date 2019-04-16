import java.util.LinkedList;

import static org.junit.Assert.*;

public class SimpleTreeTest {

    @org.junit.Test
    public void addChild() {
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1,null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2,null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3,null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4,null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5,null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(node1);
        tree.AddChild(node1,node2);
        tree.AddChild(node2,node3);
        tree.AddChild(node2,node4);
        tree.AddChild(node1,node5);
        assertTrue(tree.containNode(node1));
        assertTrue(tree.containNode(node2));
        assertTrue(tree.containNode(node3));
        assertTrue(tree.containNode(node4));
        assertTrue(tree.containNode(node5));
    }

    @org.junit.Test
    public void deleteNode() {
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1,null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2,null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3,null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4,null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(node1);
        tree.AddChild(node1,node2);
        tree.AddChild(node2,node3);
        tree.AddChild(node2,node4);

        tree.DeleteNode(node2);
        assertTrue(tree.containNode(node4));
        assertFalse(tree.containNode(node2));

        tree.DeleteNode(node3);
        assertFalse(tree.containNode(node3));

        tree.DeleteNode(node1);
        assertTrue(tree.containNode(node1));
    }

    @org.junit.Test
    public void getAllNodes() {
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1,null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2,null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3,null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4,null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5,null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(node1);
        tree.AddChild(node1,node2);
        tree.AddChild(node2,node3);
        tree.AddChild(node2,node4);
        tree.AddChild(node1,node5);
        LinkedList<SimpleTreeNode<Integer>> list = new LinkedList<SimpleTreeNode<Integer>>();
        list.add(node1);
        list.add(node2);
        list.add(node5);
        list.add(node3);
        list.add(node4);
        assertEquals(list,tree.GetAllNodes());
    }

    @org.junit.Test
    public void findNodesByValue() {
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1,null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2,null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(1,null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4,null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(1,null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(node1);
        tree.AddChild(node1,node2);
        tree.AddChild(node2,node3);
        tree.AddChild(node2,node4);
        tree.AddChild(node1,node5);
        LinkedList<SimpleTreeNode<Integer>> list = new LinkedList<SimpleTreeNode<Integer>>();
        list.add(node1);
        list.add(node5);
        list.add(node3);
        assertEquals(list,tree.FindNodesByValue(1));
    }

    @org.junit.Test
    public void moveNode() {
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1,null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2,null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3,null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4,null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5,null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(node1);
        tree.AddChild(node1,node2);
        tree.AddChild(node2,node3);
        tree.AddChild(node2,node4);
        tree.AddChild(node1,node5);
        tree.MoveNode(node2,node5);
        assertFalse(tree.Root.Children.contains(node2));
        assertFalse(tree.Root.Children.contains(node4));
        assertTrue(node5.Children.contains(node2));
    }

    @org.junit.Test
    public void count() {
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1,null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2,null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3,null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4,null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5,null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(node1);
        tree.AddChild(node1,node2);
        tree.AddChild(node2,node3);
        tree.AddChild(node2,node4);
        tree.AddChild(node1,node5);
        assertEquals(5,tree.Count());

    }

    @org.junit.Test
    public void leafCount() {
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1,null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2,null);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3,null);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4,null);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5,null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(node1);
        tree.AddChild(node1,node2);
        tree.AddChild(node2,node3);
        tree.AddChild(node2,node4);
        tree.AddChild(node1,node5);
        assertEquals(3,tree.LeafCount());
    }
}