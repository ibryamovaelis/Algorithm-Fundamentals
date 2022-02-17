package CyclesTest;

import java.util.*;

public class Main {
    public static Set<Integer> hs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        int nodes = Integer.parseInt(tokens[0]);
        int edgesCount = Integer.parseInt(tokens[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgesCount; i++) {
            String[] edges = scanner.nextLine().split(" ");
            int source = Integer.parseInt(edges[0]);
            int destination = Integer.parseInt(edges[1]);

            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        int count = 0;
        int vertices = 0;
        int edges = 0;

        boolean flag = true;
        boolean[] visited = new boolean[nodes + 1];

        for (int i = 1; i <= nodes ; i++) {
            if (visited[i] == false) {
                hs = new HashSet<>();
                int an = dfs(graph, i, visited);

                if (hs.size() - 1 != an/2) {
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println("Cycle does not exist");
        } else {
            System.out.println("Cycle exists");
        }
    }

    private static int dfs(List<List<Integer>> graph, int source, boolean[] visited) {
        hs.add(source);
        int ans = graph.get(source).size();
        visited[source] = true;

        for (int element : graph.get(source)) {
            if (!visited[element]) {
                ans += dfs(graph, element, visited);
            }
        }
        return ans;
    }
}
