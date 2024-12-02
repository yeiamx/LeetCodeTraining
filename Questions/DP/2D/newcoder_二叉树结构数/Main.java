import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(fn(a, b));
        }
    }

    private static int fn(int n, int m) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) dp[i] = 0;

        for (int j = 1; j < m; j++) {
            for (int i = n; i >= 1; i--) {
                dp[i] = 0;
                for (int k = i - 1; k >= 0; k--) {
                    dp[i] = (dp[i] + dp[k] * dp[i-k-1]) % MOD;
                }
            }
        }

        long res = 0;
        for (int k = n - 1; k >= 0; k--) {
            res = (res + dp[k] * dp[n-k-1]) % MOD;
        }
        return (int)res;
    }
}
