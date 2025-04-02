package Krisi_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Krisi {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int _t = 0; _t < T; _t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int S = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);
            int M = Integer.parseInt(input[2]);

            List<List<Route>> adj = new ArrayList<>();
            for (int i = 0; i <= S; i++) {
                adj.add(new ArrayList<>());
            }

            int maxCost = 0;
            for (int i = 0; i < L; i++) {
                String[] xyctInput = reader.readLine().trim().split("\\s+");
                int x = Integer.parseInt(xyctInput[0]);
                int y = Integer.parseInt(xyctInput[1]);
                int c = Integer.parseInt(xyctInput[2]);
                int t = Integer.parseInt(xyctInput[3]);
                adj.get(x).add(new Route(x, y, c, t));
                adj.get(y).add(new Route(y, x, c, t));
                maxCost = Math.max(maxCost, c);
            }

            int low = 1, high = maxCost, finalResult = 0;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (canReach(S, M, adj, mid)) {
                    finalResult = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            result.append(finalResult).append("\n");
        }

        System.out.print(result);
    }

    private static boolean canReach(int S, int M, List<List<Route>> adj, int maxCost) {
        int[] dist = new int[S + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int time = current[1];

            if (u == S) {
                return time <= M;
            }

            if (time > dist[u]) {
                continue;
            }

            for (Route route : adj.get(u)) {
                if (route.c <= maxCost) {
                    int v = route.y;
                    int newTime = time + route.t;
                    if (newTime < dist[v]) {
                        dist[v] = newTime;
                        pq.add(new int[]{v, newTime});
                    }
                }
            }
        }

        return dist[S] <= M;
    }

    private static class Route {

        int x, y, c, t;

        Route(int x, int y, int c, int t) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.t = t;
        }
    }
}
