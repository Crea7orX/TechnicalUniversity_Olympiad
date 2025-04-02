package NikiTheHacker_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

// 1
// BEAUTIFUL 953738ecc01feea4de

public class TEST {

    private static final int MODULO = 1 << 24; // 2^24

    // Функция за побитово кръгово ляво отместване
    private static int rotateLeft24(int value, int shift) {
        return ((value << shift) & (MODULO - 1)) | (value >>> (24 - shift));
    }

    // Функция за събиране по модул 2^24
    private static int addMod24(int a, int b) {
        return (a + b) % MODULO;
    }

    private static int bitwiseXOR(int a, int b) {
        return a ^ b;
    }

    // Функция за конвертиране на текст в 24-битови числа
    public static int[] messageToBlocks(String message) {
        int[] M = new int[3]; // 3 блока по 24 бита
        byte[] bytes = message.getBytes(); // Конвертиране на символите в байтове

        for (int i = 0; i < 3; i++) {
            M[i] = 0;
            for (int j = 0; j < 3; j++) {
                int index = i * 3 + j; // Индекс в ASCII низа
                M[i] = (M[i] << 8) | (index < bytes.length ? bytes[index] & 0xFF : 0);
            }
        }

        return M;
    }

    // Функция за конвертиране на 72-битов 16-ичен ключ в 24-битови блокове
    private static int[] keyToBlocks(String hexKey) {
        int[] K = new int[3];
        for (int i = 0; i < 3; i++) {
            K[i] = Integer.parseInt(hexKey.substring(i * 6, (i + 1) * 6), 16);
        }
        return K;
    }

    // Функция за шифроване
    public static int[] encrypt(int[] M, int[] K) {
        int[] C = new int[4];

        int M1_XOR_K1 = bitwiseXOR(M[0], K[0]);
        int M2_LEFT_K2 = rotateLeft24(M[1], K[1]);
        int M3_PLUS_K3 = addMod24(M[2], K[2]);

        // FOR C2
        int M1XORK1_XOR_M3PLUSK3 = bitwiseXOR(M1_XOR_K1, M3_PLUS_K3);
        int M1XORK1_LEFT_K3 = rotateLeft24(M1_XOR_K1, K[2]);
        int M1XORK1XORM3PLUSK3_LEFT_K2 = rotateLeft24(M1XORK1_XOR_M3PLUSK3, K[1]);
        int M1XORK1LEFTK3_XOR_M1XORK1XORM3PLUSK3LEFTK2 = bitwiseXOR(M1XORK1_LEFT_K3, M1XORK1XORM3PLUSK3_LEFT_K2);
        int M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2_LEFT_K1XORK3 = rotateLeft24(M1XORK1LEFTK3_XOR_M1XORK1XORM3PLUSK3LEFTK2, bitwiseXOR(K[0], K[2]));
        int M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3_PLUS_M1XORK1XORM3PLUSK3LEFTK2 = addMod24(M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2_LEFT_K1XORK3, M1XORK1XORM3PLUSK3_LEFT_K2);
        int M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3PLUSM1XORK1XORM3PLUSK3LEFTK2_XOR_M2LEFTK2 = bitwiseXOR(M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3_PLUS_M1XORK1XORM3PLUSK3LEFTK2, M2_LEFT_K2);
        int M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3PLUSM1XORK1XORM3PLUSK3LEFTK2XORM2LEFTK2_PLUS_K3 = addMod24(M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3PLUSM1XORK1XORM3PLUSK3LEFTK2_XOR_M2LEFTK2, K[2]);

        // FOR C1
        int M3PLUSK3_XOR_M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3 = bitwiseXOR(M3_PLUS_K3, M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2_LEFT_K1XORK3);
        int M3PLUSK3XORM1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3_LEFT_K2 = rotateLeft24(M3PLUSK3_XOR_M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3, K[1]);

        // FOR C3
        int M3PLUSK3_LEFT_K3 = rotateLeft24(M3_PLUS_K3, K[2]);
        int M3PLUSK3LEFTK3_XOR_M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3 = bitwiseXOR(M3PLUSK3_LEFT_K3, M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2_LEFT_K1XORK3);
        int M3PLUSK3LEFTK3XORM1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3_XOR_K1 = bitwiseXOR(M3PLUSK3LEFTK3_XOR_M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3, K[0]);

//        M3_PLUS_K3

//        int AfterK1AfterK2 = afterK1 ^ afterK2;
//        int AfterK1LeftK3 = rotateLeft24(afterK1, K[2]);
//        int AfterK1K2LeftK2 = rotateLeft24(AfterK1AfterK2, K[1]);
//        int AfterK1LeftK3AfterK1K2LeftK2 = AfterK1LeftK3 ^ AfterK1K2LeftK2;
//        int AfterK1LeftK3AfterK1K2LeftK2LeftK1K3 = rotateLeft24(AfterK1LeftK3AfterK1K2LeftK2, K[0] ^ K[2]);
//        int AfterK1LeftK3AfterK1K2LeftK2PlusAfterK1K2LeftK2 = addMod24(AfterK1LeftK3AfterK1K2LeftK2LeftK1K3, AfterK1K2LeftK2);
//        int AfterK1LeftK3AfterK1K2LeftK2PlusAfterK1K2LeftK2OrAfterK2 = AfterK1LeftK3AfterK1K2LeftK2PlusAfterK1K2LeftK2 ^ afterK2;
//        int AfterK1LeftK3AfterK1K2LeftK2PlusAfterK1K2LeftK2OrAfterK2PlusK3 = addMod24(AfterK1LeftK3AfterK1K2LeftK2PlusAfterK1K2LeftK2OrAfterK2, K[2]);

        C[0] = M3PLUSK3XORM1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3_LEFT_K2;
        C[1] = M1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3PLUSM1XORK1XORM3PLUSK3LEFTK2XORM2LEFTK2_PLUS_K3;
        C[2] = addMod24(M[2] ^ K[2], K[0]);
        C[3] = M3PLUSK3LEFTK3XORM1XORK1LEFTK3XORM1XORK1XORM3PLUSK3LEFTK2LEFTK1XORK3_XOR_K1;

        return C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Четем съобщението
        System.out.print("Въведете съобщение (до 9 символа): ");
        String message = scanner.nextLine();

        int[] M = messageToBlocks(message);

        System.out.println(M[0]);
        System.out.println(M[1]);
        System.out.println(M[2]);
        System.out.println("--------------------------");

        // Четем ключа
        System.out.print("Въведете 18-цифрен 16-ичен ключ: ");
        String hexKey = scanner.nextLine();

        int[] K = keyToBlocks(hexKey);

        System.out.println(K[0]);
        System.out.println(K[1]);
        System.out.println(K[2]);
        System.out.println("--------------------------");

        // Шифроване
        int[] C = encrypt(M, K);

        // Форматиране на изхода като една дълга 24-цифрена шестнадесетична стойност
        System.out.println(C[0]);
        System.out.println(C[1]);
        System.out.println(C[2]);
        System.out.println(C[3]);
        String encryptedHex = String.format("%06X\n%06X\n%06X\n%06X", C[0], C[1], C[2], C[3]);

        // Извеждаме резултата
        System.out.println("Шифрограма: " + encryptedHex.toLowerCase());
    }

//    private static String decrypt(BigInteger C, BigInteger K) {
//        int C1 = C.shiftRight(72).intValue() & BIT_MASK;
//        int C2 = C.shiftRight(48).intValue() & BIT_MASK;
//        int C3 = C.shiftRight(24).intValue() & BIT_MASK;
//        int C4 = C.intValue() & BIT_MASK;
//
//        int K1 = K.shiftRight(48).intValue() & BIT_MASK;
//        int K2 = K.shiftRight(24).intValue() & BIT_MASK;
//        int K3 = K.intValue() & BIT_MASK;
//
//        // Reverse the encoding steps as per the diagram
//        int temp = C4 ^ C3 ^ C2 ^ C1;
//        int M3 = (C3 ^ K3) - ((K1 ^ K3) << 3) & BIT_MASK;
//        int M2 = ((C2 ^ K2) - K3) & BIT_MASK;
//        int M1 = ((C1 ^ K1) - K3) & BIT_MASK;
//
//        return extractASCII(M1) + extractASCII(M2) + extractASCII(M3);
//    }
//
//    private static String extractASCII(int M) {
//        char c1 = (char) ((M >> 16) & 0xFF);
//        char c2 = (char) ((M >> 8) & 0xFF);
//        char c3 = (char) (M & 0xFF);
//        return "" + c1 + c2 + c3;
//    }
}
