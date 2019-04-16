import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = new LinkedList<SimpleTreeNode<T>>();
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) //добавления нового дочернего узла существующему ParentNode
    {
        if(containNode(ParentNode)){
            NewChild.Parent = ParentNode;
            ParentNode.Children.add(NewChild);
        }
    }

    public boolean containNode(SimpleTreeNode<T> node){
        if (Root.equals(node))
            return true;

        Queue<SimpleTreeNode<T>> queue = new LinkedList<SimpleTreeNode<T>>();
        queue.offer(Root);
        while(queue.size() != 0) {
            SimpleTreeNode<T> temp = queue.poll();
            for (SimpleTreeNode<T> x : temp.Children) {
                if (x.equals(node))
                    return true;
                queue.offer(x);
            }
        }

        return false;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)   //код удаления существующего узла NodeToDelete
    {
        if (NodeToDelete != Root) {
            NodeToDelete.Parent.Children.remove(NodeToDelete);
            for (SimpleTreeNode<T> x : NodeToDelete.Children) {
                NodeToDelete.Parent.Children.add(x);
                x.Parent = NodeToDelete.Parent;
            }
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        List<SimpleTreeNode<T>> list = new LinkedList<SimpleTreeNode<T>>();
        Queue<SimpleTreeNode<T>> queue = new LinkedList<SimpleTreeNode<T>>();
        queue.offer(Root);
        list.add(Root);
        while(queue.size() != 0) {
            SimpleTreeNode<T> temp = queue.poll();
            for (SimpleTreeNode<T> x : temp.Children) {
                list.add(x);
                queue.offer(x);
            }
        }
        return list;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        List<SimpleTreeNode<T>> list = new LinkedList<SimpleTreeNode<T>>();
        Queue<SimpleTreeNode<T>> queue = new LinkedList<SimpleTreeNode<T>>();
        queue.offer(Root);

        if(Root.NodeValue == val)
            list.add(Root);
        while(queue.size() != 0) {
            SimpleTreeNode<T> temp = queue.poll();
            for (SimpleTreeNode<T> x : temp.Children) {
                if(x.NodeValue == val)
                    list.add(x);
                queue.offer(x);
            }
        }
        return list;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) //код перемещения узла вместе с его поддеревом - в качестве дочернего для узла NewParent
    {
        if(OriginalNode != Root) {
            OriginalNode.Parent.Children.remove(OriginalNode);
            AddChild(NewParent, OriginalNode);
        }
    }

    public int Count()
    {
        int count = 1;
        Queue<SimpleTreeNode<T>> queue = new LinkedList<SimpleTreeNode<T>>();
        queue.offer(Root);

        while(queue.size() != 0) {
            SimpleTreeNode<T> temp = queue.poll();
            for (SimpleTreeNode<T> x : temp.Children) {
                count++;
                queue.offer(x);
            }
        }
        return count;
    }

    public int LeafCount()
    {
        Queue<SimpleTreeNode<T>> queue = new LinkedList<SimpleTreeNode<T>>();
        queue.offer(Root);

        int count = 0;
        while(queue.size() != 0) {
            SimpleTreeNode<T> temp = queue.poll();
            if (temp.Children.size() == 0)
                count++;

            for (SimpleTreeNode<T> x : temp.Children) {
                queue.offer(x);
            }
        }
        return count;
    }
}