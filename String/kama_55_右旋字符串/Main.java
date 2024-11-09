import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String s = scanner.next();
        char[] sArray = s.toCharArray();
        reverseStrInRange(sArray, 0, s.length() - 1);
        reverseStrInRange(sArray, 0, k - 1);
        reverseStrInRange(sArray, k, s.length() - 1);
        System.out.println(String.valueOf(sArray));
        scanner.close();
    }

    private static void reverseStrInRange(char[] s, int i, int j) {
        while (i < j) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            i++; j--;
        }
    }
}
