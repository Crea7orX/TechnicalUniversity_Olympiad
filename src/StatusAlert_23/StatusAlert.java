package StatusAlert_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StatusAlert {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            int mask = 1 << n;
            result.append(X | mask).append("\n");
        }

        System.out.print(result);
    }
}
