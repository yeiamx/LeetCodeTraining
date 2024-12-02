import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
            prefixSum[i] = sum;
        }


        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0) {
                System.out.println(prefixSum[b]);
            } else {
                System.out.println(prefixSum[b] - prefixSum[a - 1]);
            }
        }

        scanner.close();
    }
}
