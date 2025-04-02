package NikiTheHacker_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class NikiTheHacker {

    private static final int BIT_MASK = (1 << 24) - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = reader.readLine().split("\\s+");
            BigInteger C = new BigInteger(input[0], 16);
            BigInteger K = new BigInteger(input[1], 16);
            result.append(decrypt(C, K)).append("\n");
        }

        System.out.print(result);
    }

    private static String decrypt(BigInteger C, BigInteger K) {
        int C1 = C.shiftRight(72).intValue() & BIT_MASK;
        int C2 = C.shiftRight(48).intValue() & BIT_MASK;
        int C3 = C.shiftRight(24).intValue() & BIT_MASK;
        int C4 = C.intValue() & BIT_MASK;

        int K1 = K.shiftRight(48).intValue() & BIT_MASK;
        int K2 = K.shiftRight(24).intValue() & BIT_MASK;
        int K3 = K.intValue() & BIT_MASK;

        // Reverse the encoding steps as per the diagram
        int temp = C4 ^ C3 ^ C2 ^ C1;
        int M3 = (C3 ^ K3) - ((K1 ^ K3) << 3) & BIT_MASK;
        int M2 = ((C2 ^ K2) - K3) & BIT_MASK;
        int M1 = ((C1 ^ K1) - K3) & BIT_MASK;

        return extractASCII(M1) + extractASCII(M2) + extractASCII(M3);
    }

    private static String extractASCII(int M) {
        char c1 = (char) ((M >> 16) & 0xFF);
        char c2 = (char) ((M >> 8) & 0xFF);
        char c3 = (char) (M & 0xFF);
        return "" + c1 + c2 + c3;
    }
}
