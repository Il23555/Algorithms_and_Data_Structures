import java.util.*;

class Vertex
{
    public int Value;
    public Vertex(int val)
    {
        Value = val;
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
}