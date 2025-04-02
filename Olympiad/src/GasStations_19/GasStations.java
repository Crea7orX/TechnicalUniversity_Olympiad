package GasStations_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GasStations {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            int[][] dist = new int[N + 1][N + 1];

            String[] s0jInput = reader.readLine().trim().split("\\s+");
            for (int i = 1; i <= N; i++) {
                dist[0][i] = Integer.parseInt(s0jInput[i - 1]);
                dist[i][0] = dist[0][i];
            }

            for (int k = 1; k < N; k++) {
                String[] skjInput = reader.readLine().trim().split("\\s+");
                for (int j = k + 1; j <= N; j++) {
                    dist[k][j] = Integer.parseInt(skjInput[j - k - 1]);
                    dist[j][k] = dist[k][j];
                }
            }

            int[][] dp = new int[N + 1][1 << (N + 1)];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            result.append(tsp(N, dist, dp, 0, 1)).append("\n");
        }

        System.out.print(result);
    }

    private static int tsp(int N, int[][] dist, int[][] dp, int pos, int mask) {
        if (mask == (1 << (N + 1)) - 1) {
            return dist[pos][0];
        }

        if (dp[pos][mask] != -1) {
            return dp[pos][mask];
        }

        int minCost = Integer.MAX_VALUE;
        for (int next = 0; next <= N; next++) {
            if (next != pos && (mask & (1 << next)) == 0) {
                int newMask = mask | (1 << next);
                int cost = dist[pos][next] + tsp(N, dist, dp, next, newMask);
                if (cost < minCost) {
                    minCost = cost;
                }
            }
        }

        dp[pos][mask] = minCost;
        return minCost;
    }
}
