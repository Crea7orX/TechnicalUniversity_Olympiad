package MagicPotions_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MagicPotions {

    private static int bfs(int N, int start, int[] bidons) {
        int[] increments = new int[N - 2];
        int i = 2;
        for (int n = 0; n < N - 2; n++) {
            increments[n] = i++;
        }

        int[] dist = new int[N];
        dist[start] = bidons[start];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (queue.size() > 0) {
            int current = queue.poll();
            for (int increment: increments) {
                int next = current + increment;
                if (next >= N) continue;
                queue.add(next);
                dist[next] = dist[current] + bidons[next];
            }
        }

        int maxLiters = Integer.MIN_VALUE;
        for (int n = 0; n < N; n++) {
            maxLiters = Math.max(dist[n], maxLiters);
        }
        return maxLiters;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            int[] bidons = new int[N];
            String[] litersInput = reader.readLine().trim().split("\\s+");
            for (int n = 0; n < N; n++) {
                bidons[n] = Integer.parseInt(litersInput[n]);
            }

            int maxLiters = 0;
            for (int n = 0; n < N; n++) {
                maxLiters = Math.max(bfs(N, n, bidons), maxLiters);
            }

            result.append(maxLiters).append("\n");
        }

        System.out.print(result);
    }
}
