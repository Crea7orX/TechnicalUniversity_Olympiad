package OppositeMoods_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OppositeMoods {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split(" ");

            /*
            Only this solution works at Test 1 (throws RuntimeException)
            Maybe because of the input format?
            I think they have wrong "O" and not "0" in this test case,
            which throws the exception when parsing the input.

            boolean isOpposite = false;
            if (input[0].startsWith("-")) isOpposite = !isOpposite;
            if (input[1].startsWith("-")) isOpposite = !isOpposite;
            if (isOpposite) {
                result.append("Opposite\n");
            } else {
                result.append("Same\n");
            }
            */

            long A = Long.parseLong(input[0]);
            long B = Long.parseLong(input[1]);

            if ((A ^ B) < 0) {
                result.append("Opposite\n");
            } else {
                result.append("Same\n");
            }
        }

        System.out.print(result);
    }
}
