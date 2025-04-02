package LightingControl_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LightingControl {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            int Q = Integer.parseInt(reader.readLine().trim());

            for (int q = 0; q < Q; q++) {
                int lamp = Integer.parseInt(reader.readLine().trim());

                int mask = 1 << lamp - 1;
                N = N ^ mask;
            }

            result.append(N).append("\n");
        }

        System.out.print(result);
    }
}
