package LostInAMaze_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LostInAMaze {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            char[][] maze = new char[N][M];
            for (int row = 0; row < N; row++) {
                String colInput = reader.readLine().trim();
                for (int col = 0; col < M; col++) {
                   maze[row][col] = colInput.charAt(col);
                }
            }

            int startRow = -1, startCol = -1;
            int endRow = -1, endCol = -1;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (maze[row][col] == 'S') {
                        startRow = row;
                        startCol = col;
                        continue;
                    } else if (maze[row][col] == 'E') {
                        endRow = row;
                        endCol = col;
                        continue;
                    }

                    if (startRow != -1 && endRow != -1) // found start and end
                        break;
                }
            }

            boolean found = findPath(maze, N, M,
                    startRow, startCol,
                    endRow, endCol);
            result.append(found ? "Yes\n" : "No\n");
        }

        System.out.print(result);
    }

    static final int[] directionsX = {-1, 1, 0, 0};
    static final int[] directionsY = {0, 0, -1, 1};

    private static boolean findPath(char[][] maze, int rows, int cols,
                                 int startX, int startY,
                                 int endX, int endY) {
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {startX, startY}); // add start position

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int x = currentPosition[0], y = currentPosition[1];

            if (x == endX && y == endY) { // end position reached
                return true;
            }

            for (int i = 0; i < 4; i++) { // 4 directions
                int currentX = x + directionsX[i];
                int currentY = y + directionsY[i];

                if (
                    currentX >= rows || currentX < 0 || // out of range by x
                    currentY >= cols || currentY < 0 || // out of range by y
                    visited[currentX][currentY] || // already visited
                    maze[currentX][currentY] == '#' // wall
                ) continue; // continue with next direction

                visited[currentX][currentY] = true;
                queue.add(new int[]{currentX, currentY});
            }
        }

        return false;
    }
}
