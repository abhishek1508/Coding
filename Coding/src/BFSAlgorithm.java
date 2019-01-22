import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgorithm {

    private static class Graph {
        private LinkedList<Integer>[] adj;

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

    private static void BFS(int src, LinkedList<Integer>[] adj) {
        boolean[] visited = new boolean[5];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int number = queue.poll();
            System.out.print(number + " ");

            for (Integer nextNode : adj[number]) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        BFS(2, g.getAdjacencyList());
    }
}
