package FolkDance_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Deque;

public class FolkDance {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String folkDance = reader.readLine().trim();
            result.append(countValidSplits(folkDance)).append("\n");
        }

        System.out.print(result);
    }

    private static int countValidSplits(String folkDance) {
        int n = folkDance.length();
        if (folkDance.chars().filter(ch -> ch == '(').count() != folkDance.chars().filter(ch -> ch == ')').count()) {
            return 0;
        }

        int prefix = 0, minPrefix = 0, validPositions = 0;
        int[] prefixSums = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix += (folkDance.charAt(i) == '(') ? 1 : -1;
            prefixSums[i + 1] = prefix;
            if (prefix < minPrefix) {
                minPrefix = prefix;
            }
        }

        for (int i = 0; i < n; i++) {
            if (prefixSums[i] == minPrefix) {
                validPositions++;
            }
        }

        return validPositions;
    }

    // OLD CODE: NOT PASSING FIRST TESTCASE
//    private static int countValidSplits(String folkDance) {
//        int n = folkDance.length();
//
//        int totalOpen = 0;
//        int totalClose = 0;
//        for (int i = 0; i < n; i++) {
//            if (folkDance.charAt(i) == '(') {
//                totalOpen++;
//            } else {
//                totalClose++;
//            }
//        }
//
//        if (totalOpen != totalClose) {
//            return 0;
//        }
//
//        Deque<Character> deque = new ArrayDeque<>();
//        for (char c : folkDance.toCharArray()) {
//            deque.addLast(c);
//        }
//
//        int balance = 0;
//        int validSplits = 0;
//        boolean isValid = true;
//
//        for (int i = 0; i < n; i++) {
//            char current = deque.removeFirst();
//            deque.addLast(current);
//
//            if (current == '(') {
//                balance++;
//            } else {
//                balance--;
//            }
//
//            if (balance < 0) {
//                isValid = false;
//                break;
//            }
//
//            if (balance == 0) {
//                validSplits++;
//            }
//        }
//
//        if (!isValid || balance != 0) {
//            return 0;
//        }
//
//        return validSplits;
//    }
}
