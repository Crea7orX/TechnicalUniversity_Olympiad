package OptimalDistribution_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalDistribution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        StringBuilder result = new StringBuilder();

        int[] team = new int[k];
        String[] teamInput = reader.readLine().trim().split("\\s+");
        for (int i = 0; i < k; i++) {
            team[i] = Integer.parseInt(teamInput[i]);
        }

        result.append(findLexOrder(n, k, team)).append("\n");

        System.out.print(result);
    }

    private static int findLexOrder(int n, int k, int[] team) {
        int count = 1;
        for (int i = 0; i < k; i++) {
            for (int j = (i == 0 ? 0 : team[i - 1]); j < team[i]; j++) {
                count += countCombinations(n, k - i - 1, j);
            }
        }
        return count;
    }

    private static int countCombinations(int n, int k, int last) {
        if (k == 0) {
            return 1;
        }
        int count = 0;
        for (int i = last; i < n; i++) {
            count += countCombinations(n, k - 1, i);
        }
        return count;
    }
}
