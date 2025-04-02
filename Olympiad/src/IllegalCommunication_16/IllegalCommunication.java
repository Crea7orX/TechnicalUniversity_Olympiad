package IllegalCommunication_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IllegalCommunication {

    private static List<Integer>[] graph;
    private static int[] parent;
    private static boolean[] visited;
    private static List<Integer> cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        StringBuilder result = new StringBuilder();

        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int t = 0; t < M; t++) {
            String[] communicationInput = reader.readLine().trim().split("\\s+");
            while (communicationInput.length < 2) // Stupid input format from TU-Varna
                communicationInput = reader.readLine().trim().split("\\s+");

            int u = Integer.parseInt(communicationInput[0]);
            int v = Integer.parseInt(communicationInput[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];

        cycle = null;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) {
                    break;
                }
            }
        }

        if (cycle == null) {
            result.append("NO\n");
        } else {
            result.append("YES\n");
            Collections.reverse(cycle);
            for (int node : cycle) {
                result.append(node).append(" ");
            }
        }

        System.out.print(result);
    }

    private static boolean dfs(int node, int _parent) {
        visited[node] = true;
        parent[node] = _parent;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node)) {
                    return true;
                }
            } else if (neighbor != _parent) {
                cycle = new ArrayList<>();
                cycle.add(neighbor);
                int current = node;
                while (current != neighbor) {
                    cycle.add(current);
                    current = parent[current];
                }
                cycle.add(neighbor);
                return true;
            }
        }
        return false;
    }
}
