package DeliveryRouting_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DeliveryRouting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                String[] uvwInput = reader.readLine().split("\\s+");
                int U = Integer.parseInt(uvwInput[0]);
                int V = Integer.parseInt(uvwInput[1]);
                int W = Integer.parseInt(uvwInput[2]);
                graph.get(U).add(new Edge(V, W));
                graph.get(V).add(new Edge(U, W));
            }

            int S = Integer.parseInt(reader.readLine().trim());

            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[S] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.add(new int[]{S, 0});

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int u = current[0];
                int time = current[1];

                if (time > dist[u]) {
                    continue;
                }

                for (Edge edge : graph.get(u)) {
                    int v = edge.to;
                    int newTime = time + edge.weight;
                    if (newTime < dist[v]) {
                        dist[v] = newTime;
                        pq.add(new int[]{v, newTime});
                    }
                }
            }

            int totalTime = 0;
            for (int i = 1; i <= N; i++) {
                if (i != S) {
                    totalTime += dist[i];
                }
            }

            result.append(totalTime).append("\n");
        }

        System.out.print(result);
    }

    private static class Edge {

        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
