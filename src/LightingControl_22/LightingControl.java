package LightingControl_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LightingControl {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            int Q = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < Q; i++) {
                int P = Integer.parseInt(reader.readLine().trim());
                int mask = 1 << (P - 1);
                N ^= mask;
            }

            result.append(N).append("\n");
        }

        System.out.print(result);
    }
}
