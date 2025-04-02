package EmergencyCenters_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmergencyCenters {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(reader.readLine().trim());

        int[][] A = new int[N][N];
        for (int n = 0; n < N; n++) {
            String[] input = reader.readLine().trim().split("\\s+");
            for (int i = 0; i < input.length; i++) {
                A[n][i] = Integer.parseInt(input[i]);
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    for (int l = k + 1; l < N; l++) {
                        minDistance = Math.min(minDistance,
                                A[i][j] + A[i][k] + A[i][l]
                                        + A[j][k] + A[j][l] + A[k][l]);
                    }
                }
            }
        }
        result.append(minDistance).append("\n");

        System.out.print(result);
    }
}
