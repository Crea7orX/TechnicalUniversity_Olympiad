package FormationOfTeams_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FormationOfTeams {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        StringBuilder result = new StringBuilder();

        List<String> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            employees.add(reader.readLine().trim());
        }

        Collections.sort(employees);

        List<List<String>> combinations = generateCombinations(employees, k);

        for (List<String> combination : combinations) {
            for (String name : combination) {
                result.append(name).append(" ");
            }
            result.append("\n");
        }

        System.out.print(result);
    }

    private static List<List<String>> generateCombinations(List<String> employees, int k) {
        List<List<String>> result = new ArrayList<>();
        generateCombinationsHelper(employees, k, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateCombinationsHelper(List<String> employees, int k, int start, List<String> current, List<List<String>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < employees.size(); i++) {
            current.add(employees.get(i));
            generateCombinationsHelper(employees, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
