

package graphlink;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GraphLink<E> {
    protected ListLinked<Vertex<E>> listVertex;
    
    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }
    
    public void insertVertex(E data) {
        Vertex<E> newVertex = new Vertex<E>(data);
        listVertex.add(newVertex);
    }
    
    public void insertEdge(E verOri, E verDes) {
        Vertex<E> origin = findVertex(verOri);
        Vertex<E> destination = findVertex(verDes);

        if (origin != null && destination != null) {
            Edge<E> newEdge = new Edge<E>(destination);
            origin.listAdj.add(newEdge);
        }
    }
    
    private Vertex<E> findVertex(E data) {
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }
    
    public String toString() {
        return listVertex.toString();
    }
    
    public boolean searchVertex(E v) {
        for (Vertex<E> vertex : listVertex) {
            if (vertex.getData().equals(v)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean searchEdge(E v, E z) {
        Vertex<E> vertexV = findVertex(v);
        Vertex<E> vertexZ = findVertex(z);
        if (vertexV != null && vertexZ != null) {
            for (Edge<E> edge : vertexV.listAdj) {
                if (edge.getRefDest().equals(vertexZ)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void removeVertex(E v) {
        Vertex<E> vertexToRemove = findVertex(v);
        if (vertexToRemove != null) {
            // Eliminar aristas de entrada
            for (Vertex<E> vertex : listVertex) {
                if (!vertex.equals(vertexToRemove)) {
                    ListLinked<Edge<E>> adjacencyList = vertex.listAdj;
                    adjacencyList.delete(new Edge<>(vertexToRemove));
                }
            }
            // Eliminar aristas de salida
            vertexToRemove.listAdj.clear();
            // Eliminar el vértice
            listVertex.delete(vertexToRemove);
        }
    }
    
    public void removeEdge(E v, E z) {
        Vertex<E> vertexV = findVertex(v);
        Vertex<E> vertexZ = findVertex(z);
        if (vertexV != null && vertexZ != null) {
            vertexV.listAdj.delete(new Edge<>(vertexZ));
        }
    }
    public void dfs(E v) {
        Vertex<E> startVertex = findVertex(v);
        if (startVertex == null) {
            return;
        }
        Set<Vertex<E>> visited = new HashSet<>();
        dfsUtil(startVertex, visited);
    }
    private void dfsUtil(Vertex<E> vertex, Set<Vertex<E>> visited) {
        visited.add(vertex);
        System.out.print(vertex.getData() + " ");
        for (Edge<E> edge : vertex.getListAdj()) {
            Vertex<E> neighbor = edge.getRefDest();
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    } 
    
    public void bfs(E v) {
        Vertex<E> startVertex = findVertex(v);
        if (startVertex == null) {
            return;
        } 
        Queue<Vertex<E>> queue = new LinkedList<>();
        ArrayList<Vertex<E>> visited = new ArrayList<>();  
        queue.add(startVertex);
        visited.add(startVertex);    
        while (!queue.isEmpty()) {
            Vertex<E> currentVertex = queue.poll();
            System.out.println(currentVertex.getData());    
            for (Edge<E> edge : currentVertex.listAdj) {
                Vertex<E> neighborVertex = edge.getRefDest();
                if (!visited.contains(neighborVertex)) {
                    queue.add(neighborVertex);
                    visited.add(neighborVertex);
                }
            }
        }
    }
    
    
    public ArrayList<Vertex<E>> bfsPath(E v, E z) {
        Vertex<E> startVertex = findVertex(v);
        Vertex<E> endVertex = findVertex(z);
        if (startVertex == null || endVertex == null) {
            return null;
        }  
        Queue<ArrayList<Vertex<E>>> queue = new LinkedList<>();
        ArrayList<Vertex<E>> visited = new ArrayList<>();   
        ArrayList<Vertex<E>> initialPath = new ArrayList<>();
        initialPath.add(startVertex);   
        queue.add(initialPath);
        visited.add(startVertex);   
        while (!queue.isEmpty()) {
            ArrayList<Vertex<E>> currentPath = queue.poll();
            Vertex<E> currentVertex = currentPath.get(currentPath.size() - 1);      
            if (currentVertex.equals(endVertex)) {
                return currentPath;
            }      
            for (Edge<E> edge : currentVertex.listAdj) {
                Vertex<E> neighborVertex = edge.getRefDest();
                if (!visited.contains(neighborVertex)) {
                    ArrayList<Vertex<E>> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighborVertex);                
                    queue.add(newPath);
                    visited.add(neighborVertex);
                }
            }
        }  
        return null;
    }
    
    public void insertEdgeWeight(E verOri, E verDes, int weight) {
        Vertex<E> origin = findVertex(verOri);
        Vertex<E> destination = findVertex(verDes);
        if (origin != null && destination != null) {
            Edge<E> newEdge = new Edge<E>(destination, weight);
            origin.listAdj.add(newEdge);
        }
    }
    
    
    public ArrayList<E> shortPath(E verOri, E verDes) {
        Vertex<E> origin = findVertex(verOri);
        Vertex<E> destination = findVertex(verDes);
        if (origin == null || destination == null) {
            return null;
        }
        // Inicializar estructuras de datos para el algoritmo de Dijkstra
        HashMap<Vertex<E>, Integer> distances = new HashMap<>();
        HashMap<Vertex<E>, Vertex<E>> previousVertices = new HashMap<>();
        PriorityQueue<Vertex<E>> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));  
        // Establecer distancia inicial a infinito para todos los vértices, excepto el origen
        for (Vertex<E> vertex : listVertex) {
            if (vertex.equals(origin)) {
                distances.put(vertex, 0);
                queue.offer(vertex);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
        }   
        
        
        
        // Aplicar el algoritmo de Dijkstra
        while (!queue.isEmpty()) {
            Vertex<E> currentVertex = queue.poll();      
            if (currentVertex.equals(destination)) {
                break; // Hemos llegado al destino, salir del bucle
            }        
            int currentDistance = distances.get(currentVertex);       
            for (Edge<E> edge : currentVertex.listAdj) {
                Vertex<E> neighborVertex = edge.getRefDest();
                int weight = edge.getWeight();
                int distanceThroughCurrent = currentDistance + weight;           
                if (distanceThroughCurrent < distances.get(neighborVertex)) {
                    queue.remove(neighborVertex);
                    distances.put(neighborVertex, distanceThroughCurrent);
                    previousVertices.put(neighborVertex, currentVertex);
                    queue.offer(neighborVertex);
                }
            }
        }    
        // Construir la ruta más corta desde el origen hasta el destino
        ArrayList<E> shortestPath = new ArrayList<>();
        Vertex<E> currentVertex = destination;   
        while (currentVertex != null) {
            shortestPath.add(0, currentVertex.getData());
            currentVertex = previousVertices.get(currentVertex);
        }   
        return shortestPath;
    }
}