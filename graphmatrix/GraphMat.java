



package graphmatrix;
import java.util.ArrayList;
import java.util.List;

public class GraphMat<E> {
    private List<E> vertices;
    private boolean[][] adjacencyMatrix;
    public GraphMat() {
        vertices = new ArrayList<>();
        adjacencyMatrix = new boolean[0][0];
    }
    public void insertVertex(E v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
            updateMatrix();
        }
    }
    public void insertEdge(E v, E z) {
        int indexV = vertices.indexOf(v);
        int indexZ = vertices.indexOf(z);

        if (indexV != -1 && indexZ != -1) {
            adjacencyMatrix[indexV][indexZ] = true;
            adjacencyMatrix[indexZ][indexV] = true;
        }
    }

    
    public boolean searchVertex(E v) {
        return vertices.contains(v);
    }
    public boolean searchEdge(E v, E z) {
        int indexV = vertices.indexOf(v);
        int indexZ = vertices.indexOf(z);
        if (indexV != -1 && indexZ != -1) {
            return adjacencyMatrix[indexV][indexZ];
        }

        return false;
    }
    public void dfs(E v) {
        int index = vertices.indexOf(v);
        if (index != -1) {
            boolean[] visited = new boolean[vertices.size()];
            dfsTraversal(index, visited);
        }
    }

    
    
    
    private void dfsTraversal(int index, boolean[] visited) {
        visited[index] = true;
        System.out.println(vertices.get(index));

        for (int i = 0; i < vertices.size(); i++) {
            if (adjacencyMatrix[index][i] && !visited[i]) {
                dfsTraversal(i, visited);
            }
        }
    }
    private void updateMatrix() {
        boolean[][] newMatrix = new boolean[vertices.size()][vertices.size()];

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                newMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }

        adjacencyMatrix = newMatrix;
    }
}
