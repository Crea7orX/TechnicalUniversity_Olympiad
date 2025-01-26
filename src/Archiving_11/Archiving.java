package Archiving_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Archiving {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            int[] sizes = new int[N];
            String[] sizesInput = reader.readLine().trim().split("\\s+");
            for (int i = 0; i < sizesInput.length; i++) {
                sizes[i] = Integer.parseInt(sizesInput[i]);
            }

            Arrays.sort(sizes);
            for (int i = 0; i < K; i++) {
                result.append(sizes[i]).append(" ");
            }
            result.append("\n");
        }

        System.out.print(result);
    }
}
