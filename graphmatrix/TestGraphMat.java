


import graphmatrix.GraphMat;
public class TestGraphMat {
    public static void main(String[] args) {
        // Crear instancia del grafo
        GraphMat<Integer> graph = new GraphMat<>();
        // Insertar vértices
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        // Insertar aristas
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        // Buscar vértices y aristas
        System.out.println("Vertex 1 exists: " + graph.searchVertex(1));
        System.out.println("Edge between 2 and 3 exists: " + graph.searchEdge(2, 3));
        // Realizar DFS traversal desde el vértice 1
        System.out.println("DFS traversal:");
        graph.dfs(1);
    }
}


