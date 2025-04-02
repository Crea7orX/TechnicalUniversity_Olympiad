package StateChange_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StateChange {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);

            int mask = 1 << N;
            X = X ^ mask;

            result.append(X).append("\n");
        }

        System.out.print(result);
    }
}
