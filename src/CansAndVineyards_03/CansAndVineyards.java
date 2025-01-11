package CansAndVineyards_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CansAndVineyards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim()); // number of vineyards

            int third = N / 3;
            int half = N / 2;
            int totalCans = third * 2 + half;

            if (!isEven(N)) totalCans--;

            int remainingCans = totalCans / 2;

            int total = N + remainingCans;

            result.append(total).append("\n");
        }

        System.out.print(result);
    }

    private static boolean isEven(int N) {
        return N % 2 == 0;
    }
}
