package BreakCycles;

import java.util.*;
import java.util.stream.Collectors;

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

        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.destination;
            adjList.get(src).add(dest);
        }
    }
    List<Integer> remove(int index) {
        List<Integer> edgeRemoved = new ArrayList<>();
        Integer removed = adjList.get(index).remove(0);
        edgeRemoved.add(index);
        edgeRemoved.add(removed);
        return edgeRemoved;
    }
}

public class Main {
    public static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        int countNodes = 0;
        while (!line.isEmpty()) {
            countNodes++;
            String[] tokens = line.split(" -> ");

            int parent = Integer.parseInt(tokens[0]);

            List<Integer> children = Arrays
                    .stream(tokens[1].split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int child : children) {
                Edge edge = new Edge(parent, child);
                edges.add(edge);
            }
            line = scanner.nextLine();
        }

        Graph graph = new Graph(edges, countNodes);
        boolean[] discovered = new boolean[countNodes + 1];

        boolean isCycle = dfs(graph, 1, discovered, -1);

        List<List<Integer>> edgesRemoved = new ArrayList<>();

        for (List<Integer> edge : graph.adjList) {
            for (Integer integer : edge) {
                
            }
            if (isCycle) {
                List<Integer> removed = graph.remove(1);
                edgesRemoved.add(removed);
                isCycle = dfs(graph, 1, discovered, -1);
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(String.format("Edges to remove: %d", edgesRemoved.size()));
        output.append(System.lineSeparator());
        for (List<Integer> edge : edgesRemoved) {
            int source = edge.get(0);
            int destination = edge.get(1);
            output.append(String.format("%d - %d%n", source, destination));
        }
        System.out.println(output.toString());
    }

    private static boolean dfs(Graph graph, int node, boolean[] discovered, int parent) {
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
}
