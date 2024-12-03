import java.util.Arrays;

class Solution {
    public int maxSubArraySumDividedBySeven(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][7];
        for (int j = 0; j < 7; j++) {
            dp[0][j] = nums[0] % 7 == j ? nums[0] : -1;
        }

        for (int i = 1; i < n; i++) {
            int ki = nums[i] % 7;
            for (int j = 0; j < 7; j++) {
                dp[i][j] = dp[i-1][j];

                int k = ki <= j ? j - ki : j + 7 - ki;
                if (dp[i-1][k] != -1) {
                    dp[i][j] = Math.max(dp[i][j], nums[i] + dp[i-1][k]);
                } else if (ki == j) {
                    dp[i][j] = Math.max(dp[i][j], nums[i]);
                }
            }
        }
        return dp[n-1][0] == -1 ? 0 : dp[n-1][0];
    }

    // 暴力方法
    // 为了验证
    public int correcter(int[] nums) {
        // nums形成的所有子序列的累加和都求出来
        // 其中%7==0的那些累加和中，返回最大的
        // 就是如下f函数的功能
        return f(nums, 0, 0);
    }

    public static int f(int[] nums, int i, int s) {
        if (i == nums.length) {
            return s % 7 == 0 ? s : 0;
        }
        return Math.max(f(nums, i + 1, s), f(nums, i + 1, s + nums[i]));
    }
}