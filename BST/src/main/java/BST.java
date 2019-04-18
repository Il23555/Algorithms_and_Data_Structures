import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.util.*;


class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если не найден узел, и в дереве только один корень
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node)
    {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) // ищем в дереве узел и сопутствующую информацию по ключу
    {
        BSTFind<T> search = new BSTFind<T>();
        search.Node = Root;
        while(!search.NodeHasKey) {
            if (search.Node.NodeKey > key) {
                if (search.Node.LeftChild != null)
                    search.Node = search.Node.LeftChild;
                else {
                    search.ToLeft = true;
                    return search;
                }
            }

            if (search.Node.NodeKey < key) {
                if (search.Node.RightChild != null)
                    search.Node = search.Node.RightChild;
                else
                    return search;
            }

            if (search.Node.NodeKey == key)
                search.NodeHasKey = true;
        }
        return search;
    }

    public boolean AddKeyValue(int key, T val) // добавляем ключ-значение в дерево
    {
        BSTFind Parent = FindNodeByKey(key);

        if (!Parent.NodeHasKey){
            BSTNode<T> Child = new BSTNode<T>(key,val,Parent.Node);
            if (Parent.ToLeft)
                Parent.Node.LeftChild = Child;
            else
                Parent.Node.RightChild = Child;
            return true;
        }

        return false; // если ключ уже есть
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)// ищем максимальное/минимальное в поддереве
    {
        BSTNode<T> Node = FromNode;
        if (FindMax) {
            while (Node.RightChild != null)
                Node = Node.RightChild;
        }
        else{
            while(Node.LeftChild != null)
                Node = Node.LeftChild;
        }

        return Node;
    }

    public boolean DeleteNodeByKey(int key)// удаляем узел по ключу ???????????можно ли сократить
    {
        //находим удаляемый узел
        BSTFind<T> DeleteNode = FindNodeByKey(key);

        if(!DeleteNode.NodeHasKey) {
            return false;
        }

        //находим чем заменить данный узел
        BSTNode<T> NodeInsert;
        if(DeleteNode.Node.RightChild != null) {
            NodeInsert = DeleteNode.Node.RightChild;
            while (NodeInsert.LeftChild != null)
                NodeInsert = NodeInsert.LeftChild;
        }
        else {
            NodeInsert = DeleteNode.Node.LeftChild;
        }

        //замена
        if (NodeInsert != null) {

            if(NodeInsert.Parent.LeftChild == NodeInsert) //?????
                NodeInsert.Parent.LeftChild = null;
            else
                NodeInsert.Parent.RightChild = null;

            if (DeleteNode.Node.RightChild != null) {
                DeleteNode.Node.RightChild.Parent = NodeInsert;
                NodeInsert.RightChild = DeleteNode.Node.RightChild;
            }

            if (DeleteNode.Node.LeftChild != null) {
                DeleteNode.Node.LeftChild.Parent = NodeInsert;
                NodeInsert.LeftChild = DeleteNode.Node.LeftChild;
            }

            if(DeleteNode.Node != Root)
                NodeInsert.Parent = DeleteNode.Node.Parent;
        }

        if (DeleteNode.Node != Root) {
            if (DeleteNode.Node.Parent.NodeKey > DeleteNode.Node.NodeKey)
                DeleteNode.Node.Parent.LeftChild = NodeInsert;
            else
                DeleteNode.Node.Parent.RightChild = NodeInsert;
        }
        else
            Root = NodeInsert;

        return true;
    }

    public int Count() // количество узлов в дереве
    {
        int count = 0;
        Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
        queue.offer(Root);

        BSTNode<T> temp;
        while(queue.size()>0){
           temp = queue.poll();
           count++;
           if(temp.LeftChild != null){
               queue.offer(temp.LeftChild);
           }
           if(temp.RightChild != null) {
               queue.offer(temp.RightChild);
           }
        }
        return count;
    }

}