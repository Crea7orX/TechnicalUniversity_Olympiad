package Events_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Events {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int P = Integer.parseInt(input[0]); // participants
            int R = Integer.parseInt(input[1]); // prizes
            int N = Integer.parseInt(input[2]); // total participants
            int M = Integer.parseInt(input[3]); // total prizes

            long participantsCombinations = combination(N, P);
            long prizesCombinations = combination(M, R);

            long total = participantsCombinations * prizesCombinations;

            result.append(total).append("\n");
        }

        System.out.print(result);
    }

    private static long factorial(int N) {
        if (N == 0) {
            return 1;
        }
        return N * factorial(N - 1);
    }

    private static long combination(int N, int P) {
        if (P > N) return 0;
        return factorial(N) / (factorial(P) * factorial(N - P));
    }
}
