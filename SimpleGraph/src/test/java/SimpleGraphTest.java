import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleGraphTest {

    @org.junit.Test
    public void addVertex() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        assertEquals(0,graph.vertex[0].Value);
        for (int i = 0; i < 5 ; i++) {
            assertEquals(0,graph.m_adjacency[0][i]);
        }
    }

    @org.junit.Test
    public void removeVertex() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddEdge(0,1);
        graph.AddEdge(0,4);
        assertEquals(0,graph.vertex[0].Value);
        assertTrue(graph.IsEdge(0,1));
        assertTrue(graph.IsEdge(0,4));

        graph.RemoveVertex(0);

        assertEquals(null,graph.vertex[0]);
        assertFalse(graph.IsEdge(0,1));
        assertFalse(graph.IsEdge(0,4));
        assertFalse(graph.IsEdge(1,0));
        assertFalse(graph.IsEdge(4,0));

        graph.AddVertex(5);
        assertEquals(5,graph.vertex[0].Value);
    }

    @org.junit.Test
    public void isEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0,1);
        graph.AddEdge(2,1);
        assertTrue(graph.IsEdge(0,1));
        assertTrue(graph.IsEdge(2,1));
        assertFalse(graph.IsEdge(0,2));
        assertFalse(graph.IsEdge(0,4));
    }

    @org.junit.Test
    public void addEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(0,1);
        graph.AddEdge(2,1);
        assertTrue(graph.IsEdge(0,1));
        assertTrue(graph.IsEdge(2,1));
    }

    @org.junit.Test
    public void removeEdge() {
        SimpleGraph graph = new SimpleGraph(5);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddEdge(0,1);
        assertTrue(graph.IsEdge(0,1));
        graph.RemoveEdge(0,1);
        assertFalse(graph.IsEdge(0,1));
    }

    @Test
    public void depthFirstSearch() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddEdge(0,1);
        graph.AddEdge(0,2);
        graph.AddEdge(1,3);
        graph.AddEdge(2,4);
        graph.AddEdge(2,5);
        graph.AddEdge(3,4);
        graph.AddEdge(4,6);
        graph.AddEdge(6,5);
        ArrayList<Vertex> list = graph.DepthFirstSearch(0,5);
        assertEquals(0,list.get(0).Value);
        assertEquals(1,list.get(1).Value);
        assertEquals(3,list.get(2).Value);
        assertEquals(4,list.get(3).Value);
        assertEquals(2,list.get(4).Value);
        assertEquals(5,list.get(5).Value);
    }

    @Test
    public void breadthFirstSearch() {
        SimpleGraph graph = new SimpleGraph(7);
        graph.AddVertex(2);
        graph.AddVertex(0);
        graph.AddVertex(6);
        graph.AddVertex(8);
        graph.AddVertex(4);
        graph.AddVertex(1);
        graph.AddVertex(3);

        graph.AddEdge(0,1);
        graph.AddEdge(0,6);

        graph.AddEdge(1,2);

        graph.AddEdge(2,3);
        graph.AddEdge(2,4);
        graph.AddEdge(2,5);

        graph.AddEdge(4,6);
        graph.AddEdge(5,6);

        ArrayList<Vertex> list = graph.BreadthFirstSearch(6,1);
        assertEquals(3,list.get(0).Value);
        assertEquals(2,list.get(1).Value);
        assertEquals(0,list.get(2).Value);
    }


    @Test
    public void weakVertices() {

        SimpleGraph graph = new SimpleGraph(9);
        graph.AddVertex(2);
        graph.AddVertex(0);
        graph.AddVertex(6);
        graph.AddVertex(8);
        graph.AddVertex(4);
        graph.AddVertex(1);
        graph.AddVertex(3);
        graph.AddVertex(5);
        graph.AddVertex(7);

        graph.AddEdge(0,1);
        graph.AddEdge(0,2);
        graph.AddEdge(0,6);

        graph.AddEdge(1,2);
        graph.AddEdge(2,6);

        graph.AddEdge(4,3);
        graph.AddEdge(1,4);
        graph.AddEdge(2,3);

        graph.AddEdge(3,5);
        graph.AddEdge(3,7);
        graph.AddEdge(7,8);
        graph.AddEdge(7,5);

        ArrayList<Vertex> list = graph.WeakVertices();
        assertEquals(4,list.get(0).Value);
        assertEquals(7,list.get(1).Value);
    }
}