class Solution {
    private static int MOD = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = group.length - 1; i >= 1; i--) {
            for (int r = n; r >= group[i]; r--) {
                for (int s = minProfit; s >= 0; s--) {
                    dp[r][s] = (dp[r][s] + dp[r-group[i]][Math.max(s-profit[i], 0)]) % MOD;
                }
            }
        }

        dp[n][minProfit] = (dp[n][minProfit] + (n >= group[0] ? dp[n-group[0]][Math.max(minProfit-profit[0], 0)] : 0)) % MOD;
        return dp[n][minProfit];
    }

}