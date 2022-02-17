package CyclesInGraph;

import java.util.*;

public class Main {
    public static Map<String, List<String>> graph = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String source = null;

        while (!line.equals("End")) {
            String[] tokens = line.split("-");
            if (source == null) {
                source = tokens[0];
            }

            graph.putIfAbsent(tokens[0], new ArrayList<>());
            graph.get(tokens[0]).add(tokens[1]);

            line = scanner.nextLine();
        }

        Set<String> visited = new HashSet<>();
        Set<String> cycles = new HashSet<>();

        String out = "";
        try {
            for (String s : graph.keySet()) {
                if (!visited.contains(s)) {
                    dfs(s, visited, cycles);
                    out = "Acyclic: Yes";
                }
            }
        } catch (IllegalStateException ex) {
            out = ex.getMessage();
        }
        System.out.println(out);
    }

    private static void dfs(String source, Set<String> visited, Set<String> cycles) {
        if (cycles.contains(source)) {
            throw new IllegalStateException("Acyclic: No");
        }
        if (visited.contains(source)) {
            return;
        }

        cycles.add(source);
        visited.add(source);

        List<String> children = graph.get(source);
        if (children == null) {
            return;
        }
        for (String child : children) {
            dfs(child, visited, cycles);
        }
        cycles.remove(source);

    }
}
