import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();
        char[] sArray = s.toCharArray();
        int numCount = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (Character.isDigit(sArray[i])) {
                numCount++;
            }
        }
        int orgLen = sArray.length;
        int len = orgLen + 5 * numCount;
        char[] resArray = new char[len];
        System.arraycopy(sArray, 0, resArray, 0, orgLen);
        sArray = null;

        int i = orgLen - 1; int j = len - 1;
        while (i >= 0) {
            if (!Character.isDigit(resArray[i])) {
                resArray[j] = resArray[i];
            } else {
                resArray[j--] = 'r';
                resArray[j--] = 'e';
                resArray[j--] = 'b';
                resArray[j--] = 'm';
                resArray[j--] = 'u';
                resArray[j] = 'n';
            }
            i--; j--;
        }

        System.out.println(String.valueOf(resArray));
        scanner.close();
    }
}
