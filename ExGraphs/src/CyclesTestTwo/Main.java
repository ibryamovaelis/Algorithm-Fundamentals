package CyclesTestTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge {
    int source;
    int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}

class Graph {
    List<List<Integer>> adjList = null;

    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.destination;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

public class Main {
    public static boolean dfs(Graph graph, int node, boolean[] discovered, int parent) {
        discovered[node] = true;

        for (int w : graph.adjList.get(node)) {
            if (!discovered[w]) {
                if (dfs(graph, w, discovered, node)) {
                    return true;
                }
            } else if (w != parent) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 6), new Edge(0, 7),
                new Edge(1, 2), new Edge(1, 5), new Edge(2, 3),
                new Edge(2, 4), new Edge(7, 8), new Edge(7, 11),
                new Edge(8, 9), new Edge(8, 10), new Edge(10, 11)
        );

        int nodesCount = 12;

        Graph graph = new Graph(edges, nodesCount);
        boolean[] discovered = new boolean[nodesCount];

        if (dfs(graph, 0, discovered, -1)) {
            System.out.println("Cycle: Yes");
        } else {
            System.out.println("Cycle: No");
        }
    }
}
