package MinimumDistance_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().trim().split("\\s+");
            int xA = Integer.parseInt(input[0]);
            int yA = Integer.parseInt(input[1]);
            int xB = Integer.parseInt(input[2]);
            int yB = Integer.parseInt(input[3]);
            int xX = Integer.parseInt(input[4]);
            int yX = Integer.parseInt(input[5]);

            double distance = pointToLineDistance(xA, yA, xB, yB, xX, yX);
            result.append(String.format("%.2f", distance)).append("\n");
        }

        System.out.print(result);
    }

    private static double pointToLineDistance(int xA, int yA, int xB, int yB, int xX, int yX) {
        double numerator = Math.abs((yB - yA) * xX - (xB - xA) * yX + xB * yA - yB * xA);
        double denominator = Math.sqrt(Math.pow(yB - yA, 2) + Math.pow(xB - xA, 2));
        return numerator / denominator;
    }
}
