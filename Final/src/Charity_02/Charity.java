package Charity_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Charity {

    private static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return (n * factorial(n - 1));
    }

    private static long combination(int n, int k) {
        return (factorial(n) / factorial(n - k)) / factorial(k);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int H = Integer.parseInt(input[0]);
            int D = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]);
            int M = Integer.parseInt(input[3]);

            result.append(combination(N, H) * combination(M, D)).append("\n");
        }

        System.out.print(result);
    }
}
