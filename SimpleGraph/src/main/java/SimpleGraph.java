import java.util.*;
class Vertex
{
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size)
    {
        max_vertex = size;
        m_adjacency = new int [size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value) //добавление новой вершины с значением value в незанятую позицию vertex
    {
        Vertex new_vertex = new Vertex(value);
        int i = 0;
        while ((i < max_vertex) && (vertex[i] != null)){
            i++;
        }
        if (i < max_vertex)
            vertex[i] = new_vertex;
    }

    // здесь и далее, параметры v -- индекс вершины в списке  vertex

    public void RemoveVertex(int v) //удаление вершины со всеми её рёбрами
    {
        vertex[v] = null;
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[i][v] = 0;
            m_adjacency[v][i] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) // true если есть ребро между вершинами v1 и v2
    {
        if ((v1 < max_vertex && v2 < max_vertex) && (vertex[v1] != null && vertex[v2] != null)){
            if (m_adjacency[v1][v2] == 1 && m_adjacency[v2][v1] == 1)
                return true;
        }
        return false;
    }

    public void AddEdge(int v1, int v2) // добавление ребра между вершинами v1 и v2
    {
        if ((v1 < max_vertex && v2 < max_vertex) && (vertex[v1] != null && vertex[v2] != null)){
            m_adjacency[v1][v2] = 1;
            m_adjacency[v2][v1] = 1;
        }
    }

    public void RemoveEdge(int v1, int v2) // удаление ребра между вершинами v1 и v2
    {
        if ((v1 < max_vertex && v2 < max_vertex) && (vertex[v1] != null && vertex[v2] != null)){
            m_adjacency[v1][v2] = 0;
            m_adjacency[v2][v1] = 0;
        }
    }

    //DFS
    // Узлы задаются позициями в списке vertex. Возвращается список узлов -- путь из VFrom в VTo. Список пустой, если пути нету.
    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo)
    {
        ArrayList<Vertex> list = new ArrayList<Vertex>();
        Stack<Integer> stack = new Stack<Integer>();

        int temp = VFrom;
        vertex[temp].Hit = true;
        stack.push(temp);

        while(stack.size() > 0){
            temp = stack.peek();

            if (m_adjacency[temp][VTo] != 0){
                stack.push(VTo);
                break;
            }

            int i = 0;
            while (i < max_vertex) {
                if ((m_adjacency[temp][i] != 0) && (!vertex[i].Hit)){
                    vertex[i].Hit = true;
                    stack.push(i);
                    break;
                }
                i++;
            }

            if (i == max_vertex) {
                stack.pop();
            }
        }

        for (Integer x : stack){
            list.add(vertex[x]);
        }
        return list;
    }
}