package DroneDeliveries_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DroneDeliveries {

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] directions = { { -1, 0 }, { -1, 1 }, { -1, -1 } };
    private static boolean isValid(int N, int M, int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static int bfs(int N, int M, Point start, int[][] buildings) {
        boolean[][] visited = new boolean[N][M];
        int[][] dist = new int[N][M];

        visited[start.x][start.y] = true;
        dist[start.x][start.y] = buildings[start.x][start.y];

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while (queue.size() > 0) {
            Point current = queue.poll();
            for (int[] direction: directions) {
                int x = current.x + direction[0];
                int y = current.y + direction[1];
                if (isValid(N, M, x, y) && !visited[x][y]) {
                    queue.add(new Point(x, y));
                    visited[x][y] = true;
                    dist[x][y] = dist[current.x][current.y] + buildings[x][y];
                }
            }
        }

        int minEnergy = Integer.MAX_VALUE;
        for (int m = 0; m < M; m++) {
            minEnergy = Math.min(dist[0][m], minEnergy);
        }
        return minEnergy;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String[] sizeInput = reader.readLine().trim().split("\\s+");
        int N = Integer.parseInt(sizeInput[0]);
        int M = Integer.parseInt(sizeInput[1]);

        int[][] buildings = new int[N][M];

        for (int n = 0; n < N; n++) {
            String[] input = reader.readLine().trim().split("\\s+");
            for (int m = 0; m < M; m++) {
                buildings[n][m] = Integer.parseInt(input[m]);
            }
        }

        int minEnergy = Integer.MAX_VALUE;
        for (int m = 0; m < M; m++) {
            minEnergy = Math.min(bfs(N, M, new Point(N - 1, m), buildings), minEnergy);
        }
        result.append(minEnergy).append("\n");

        System.out.print(result);
    }
}
