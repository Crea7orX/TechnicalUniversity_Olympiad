package Playground_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Playground {

    private static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return (n * factorial(n - 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            result.append(factorial(N - 1)).append("\n");
        }

        System.out.print(result);
    }
}
