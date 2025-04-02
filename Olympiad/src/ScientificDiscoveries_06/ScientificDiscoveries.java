package ScientificDiscoveries_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class ScientificDiscoveries {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(reader.readLine().trim());
            int[] observations = Arrays.stream(reader.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            Stack<Integer> indicesStack = new Stack<>();

            for (int i = 0; i < N; i++) {
                while (!indicesStack.isEmpty() &&
                        observations[indicesStack.peek()] >= observations[i]) {
                    indicesStack.pop();
                }

                result.append(indicesStack.isEmpty() ? 0 : indicesStack.peek() + 1)
                        .append(" ");

                indicesStack.push(i);
            }
            result.append("\n");
        }

        System.out.print(result);
    }
}
