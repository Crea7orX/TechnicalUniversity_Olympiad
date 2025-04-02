package FireSafety_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FireSafety {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[][] building = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                String[] row = reader.readLine().split("\\s+");
                for (int j = 0; j < m; j++) {
                    building[i][j] = Integer.parseInt(row[j]);
                }
            }

            String[] startInput = reader.readLine().split("\\s+");
            int startX = Integer.parseInt(startInput[0]);
            int startY = Integer.parseInt(startInput[1]);

            if (startX < 0 || startX >= n || startY < 0 || startY >= m || building[startX][startY] == 1) {
                result.append("Invalid starting point\n");
                continue;
            }

            bfs(building, visited, startX, startY, n, m);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    result.append(visited[i][j] ? 1 : 0).append(" ");
                }
                result.append("\n");
            }
        }

        System.out.print(result);
    }

    private static void bfs(int[][] building, boolean[][] visited, int startX, int startY, int n, int m) {
        int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && building[newX][newY] == 0) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }
}
