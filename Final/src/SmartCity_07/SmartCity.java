package SmartCity_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SmartCity {

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] directions = { { 0, 1 }, { 1, 0 } };
    private static boolean isValid(int N, int M, int x, int y, int[][] roads) {
        return x >= 0 && x < N && y >= 0 && y < M && roads[x][y] == 0;

    }
    private static int bfs(int N, int M, Point start, int[][] roads) {
        int count = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        while (queue.size() > 0) {
            Point current = queue.poll();
            for (int[] direction: directions) {
                int x = current.x + direction[0];
                int y = current.y + direction[1];
                if (isValid(N, M, x, y, roads)) {
                    queue.add(new Point(x, y));
                    if (x == N - 1 && y == M - 1)
                        count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            String[] sizeInput = reader.readLine().trim().split("\\s+");
            int N = Integer.parseInt(sizeInput[0]);
            int M = Integer.parseInt(sizeInput[1]);

            int[][] roads = new int[N][M];

            for (int n = 0; n < N; n++) {
                String[] input = reader.readLine().trim().split("\\s+");
                for (int m = 0; m < M; m++) {
                    roads[n][m] = Integer.parseInt(input[m]);
                }
            }

            result.append(bfs(N, M, new Point(0, 0), roads)).append("\n");
        }

        System.out.print(result);
    }
}
