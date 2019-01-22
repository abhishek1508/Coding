import java.util.LinkedList;

public class DFSAlgorithm {
    private static class Graph {
        LinkedList<Integer>[] adj;
        Graph(int numberOfVertices) {
            adj = new LinkedList[numberOfVertices];
            for (int i = 0; i < numberOfVertices; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        private void addEdge(int src, int dest) {
            adj[src].add(dest);
        }

        private LinkedList<Integer>[] getAdjacencyList() {
            return adj;
        }
    }

    private static void DFS(int src, LinkedList<Integer>[] adj) {
        boolean[] visited = new boolean[4];
        DFSUtil(src, visited, adj);
    }

    private static void DFSUtil(int v, boolean[] visited, LinkedList<Integer>[] adj) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Integer value : adj[v]) {
            if (!visited[value]) {
                DFSUtil(value, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        DFS(2, g.getAdjacencyList());
    }
}
