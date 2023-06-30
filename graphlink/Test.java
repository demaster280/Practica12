




package graphlink;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        
        /* //test01
        // Crear un grafo
        GraphLink<String> graph = new GraphLink<>();
        // Insertar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        // Insertar aristas
        graph.insertEdge("A", "B");
        graph.insertEdge("B", "C");
        graph.insertEdge("C", "D");
        graph.insertEdge("D", "A");
        // Imprimir el grafo
        System.out.println(graph);
        // Obtener datos de un vértice
        Vertex<String> vertexB = graph.findVertex("B");
        if (vertexB != null) {
            System.out.println("Datos del vértice B: " + vertexB.getData());
        }
        // Verificar igualdad de vértices
        Vertex<String> vertexC = graph.findVertex("C");
        if (vertexC != null) {
            if (vertexB.equals(vertexC)) {
                System.out.println("Los vértices B y C son iguales.");
            } else {
                System.out.println("Los vértices B y C son diferentes.");
            }
        }     
    */
        /*  //test02
        // Crear un grafo
        GraphLink<Integer> graph = new GraphLink<>();
        // Insertar vértices
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        // Insertar aristas
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 1);
        // Imprimir el grafo
        System.out.println(graph);
        // Buscar un vértice existente
        int vertexToSearch = 3;
        if (graph.searchVertex(vertexToSearch)) {
            System.out.println("El vertice " + vertexToSearch + " existe en el grafo.");
        } else {
            System.out.println("El vertice " + vertexToSearch + " no existe en el grafo.");
        }
        // Buscar un vértice inexistente
        int nonExistingVertex = 5;
        if (graph.searchVertex(nonExistingVertex)) {
            System.out.println("El vertice " + nonExistingVertex + " existe en el grafo.");
        } else {
            System.out.println("El vertice " + nonExistingVertex + " no existe en el grafo.");
        }
        // Buscar una arista existente
        int vertexV = 2;
        int vertexZ = 3;
        if (graph.searchEdge(vertexV, vertexZ)) {
            System.out.println("Existe una arista entre los vertices " + vertexV + " y " + vertexZ + ".");
        } else {
            System.out.println("No existe una arista entre los vertices " + vertexV + " y " + vertexZ + ".");
        }
        // Buscar una arista inexistente
        int nonExistingVertexV = 1;
        int nonExistingVertexZ = 4;
        if (graph.searchEdge(nonExistingVertexV, nonExistingVertexZ)) {
            System.out.println("Existe una arista entre los vertices " + nonExistingVertexV + " y " + nonExistingVertexZ + ".");
        } else {
            System.out.println("No existe una arista entre los vertices " + nonExistingVertexV + " y " + nonExistingVertexZ + ".");
        }
        */  
        /*     //test03
        GraphLink<String> graph = new GraphLink<>();
        // Insertar vértices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        // Insertar aristas
        graph.insertEdge("A", "B");
        graph.insertEdge("A", "C");
        graph.insertEdge("B", "D");
        graph.insertEdge("C", "D");
        System.out.println("Grafo original:");
        System.out.println(graph);
        // Eliminar vértice
        graph.removeVertex("B");
        System.out.println("Grafo despues de eliminar el vertice 'B':");
        System.out.println(graph);
        // Eliminar arista
        graph.removeEdge("A", "C");
        System.out.println("Grafo despues de eliminar la arista entre 'A' y 'C':");
        System.out.println(graph);
        */ 
        
        /*     //test04
        GraphLink<Integer> graph = new GraphLink<>();
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        
        System.out.println("DFS traversal:");
        graph.dfs(1);    
        */
        
        /*     //test05
        GraphLink<Integer> graph = new GraphLink<>();
        // Insertar vértices
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        // Insertar aristas
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);
        // Realizar BFS desde el vértice 1
        System.out.println("BFS traversal:");
        graph.bfs(1);
        // Obtener el camino entre el vértice 1 y 4
        ArrayList<Vertex<Integer>> path = graph.bfsPath(1, 4);
        // Mostrar el camino si existe
        if (path != null) {
            System.out.println("Path from 1 to 4: " + path);
        } else {
            System.out.println("No path found from 1 to 4.");
        }
        */
        
        GraphLink<Integer> graph = new GraphLink<>();        
        // Insertar vértices
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);        
        // Insertar aristas con peso
        graph.insertEdgeWeight(1, 2, 2);
        graph.insertEdgeWeight(2, 3, 3);
        graph.insertEdgeWeight(3, 4, 1);
        graph.insertEdgeWeight(1, 4, 4);        
        // Calcular ruta más corta
        ArrayList<Integer> shortestPath = graph.shortPath(1, 4);        
        // Imprimir ruta más corta
        System.out.println("Shortest Path from 1 to 4: " + shortestPath);
        
    }
}




