package GasStations_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GasStations {

    private static int getShortestRoute(int gasStationsCount, int[][] dist, int[][] dp, int pos, int mask) {
        int minDistance = Integer.MAX_VALUE;

        if ((1 << (gasStationsCount + 1)) - 1 == mask) {
            return dist[pos][0];
        }
        if (dp[pos][mask] != -1) {
            return dp[pos][mask];
        }

        for (int i = 0; i <= gasStationsCount; i++) {
            if (i != pos && (mask & (1 << i)) == 0) {
                int distance = dist[pos][i] + getShortestRoute(gasStationsCount, dist, dp, i, mask | (1 << i));
                minDistance = Math.min(distance, minDistance);
            }
        }
        dp[pos][mask] = minDistance;
        return minDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            int[][] gasStations = new int[N + 1][N + 1];

            String[] startShortestRouteInput = reader.readLine().trim().split("\\s+");
            for (int n = 1; n <= N; n++) {
                gasStations[0][n] = Integer.parseInt(startShortestRouteInput[n - 1]);
                gasStations[n][0] = gasStations[0][n];
            }
            for (int n = 1; n < N; n++) {
                String[] shortestRouteInput = reader.readLine().trim().split("\\s+");
                for (int nn = n + 1; nn <= N; nn++) {
                    gasStations[n][nn] = Integer.parseInt(shortestRouteInput[nn - n - 1]);
                    gasStations[nn][n] = gasStations[n][nn];
                }
            }

            int[][] dp = new int[N + 1][1 << (N + 1)];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            result.append(getShortestRoute(N, gasStations, dp, 0, 1)).append("\n");
        }

        System.out.print(result);
    }
}
