package OrderOfTasks_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OrderOfTasks {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            String[] tasksInput = reader.readLine().trim().split("\\s+");
            int[] tasks = new int[k];
            for (int i = 0; i < k; i++) {
                tasks[i] = Integer.parseInt(tasksInput[i]);
            }

            result.append(findPermutationRank(tasks, n, k)).append("\n");
        }

        System.out.print(result);
    }

    private static int findPermutationRank(int[] tasks, int n, int k) {
        List<Integer> availableTasks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            availableTasks.add(i);
        }

        int rank = 1;
        for (int i = 0; i < k; i++) {
            int currentTask = tasks[i];
            int index = availableTasks.indexOf(currentTask);
            rank += index * factorial(n - 1 - i);
            availableTasks.remove(index);
        }
        return rank;
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}
