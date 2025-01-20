package DailyStatus_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DailyStatus {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(reader.readLine().trim());
            int D = Integer.parseInt(reader.readLine().trim());

            result.append(isWorking(N, D) ? "Operational\n" : "Off\n");
        }

        System.out.print(result);
    }

    private static boolean isWorking(long N, int D) {
        boolean shouldShift = N % 2 != 0;
        return (N & (1 << (shouldShift ? D - 1 : D))) != 0;
    }
}
