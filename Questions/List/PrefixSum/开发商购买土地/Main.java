import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); int m = scanner.nextInt();
        int[][] nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int[] verticalPreSum = new int[m];
        int[] horizontalPreSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += nums[i][j];
            }
            horizontalPreSum[i] = sum;
        }
        sum = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                sum += nums[i][j];
            }
            verticalPreSum[j] = sum;
        }
        int minDiff = Integer.MAX_VALUE;
        //遍历分界线 i代表将[0,i] 与 [i+1, len-1]分开的一条分界线
        //易得diff= (preSum[len - 1] - preSum[i]) - preSum[i];
        //竖直
        if (m > 1) {
            for (int i = 0; i < m - 1; i++) {
                int diff = verticalPreSum[m - 1] - 2 * verticalPreSum[i];
                if (diff == 0) {
                    System.out.println(0);
                    return;
                }
                if (diff < 0) diff = -diff;
                minDiff = Math.min(minDiff, diff);
            }
        }
        //水平
        if (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int diff = horizontalPreSum[n - 1] - 2 * horizontalPreSum[i];
                if (diff == 0) {
                    System.out.println(0);
                    return;
                }
                if (diff < 0) diff = -diff;
                minDiff = Math.min(minDiff, diff);
            }
        }
        System.out.println(minDiff);
        scanner.close();
    }
}
