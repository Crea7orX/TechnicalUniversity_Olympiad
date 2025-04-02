package Researchers_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Researchers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                String[] edgeInput = reader.readLine().trim().split("\\s+");
                int u = Integer.parseInt(edgeInput[0]);
                int v = Integer.parseInt(edgeInput[1]);
                int weight = Integer.parseInt(edgeInput[2]);
                graph.get(u).add(new Edge(v, weight));
                graph.get(v).add(new Edge(u, weight));
            }

            result.append(dijkstra(N, graph)).append("\n");
        }

        System.out.print(result);
    }

    private static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static int dijkstra(int n, List<List<Edge>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 1});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int node = current[1];

            if (d > dist[node]) continue;

            for (Edge edge : graph.get(node)) {
                int newDist = d + edge.weight;

                if (newDist < dist[edge.to]) {
                    dist[edge.to] = newDist;
                    pq.add(new int[]{newDist, edge.to});
                }
            }
        }

        return dist[n] == Integer.MAX_VALUE ? -1 : dist[n];
    }
}
