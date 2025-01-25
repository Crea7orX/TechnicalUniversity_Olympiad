package RitualCircle_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RitualCircle {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            result.append(factorial(N - 1)).append("\n");
        }

        System.out.print(result);
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
