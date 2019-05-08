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
}