class Solution {

    public static int MOD = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length; int m = grid[0].length;
        int[][][] dp = new int[n][m][k];

        dp[n-1][m-1][grid[n-1][m-1] % k] = 1;
        for (int j = m-2; j >= 0; j--) {
            for (int r = 0; r < k; r++) {
                // 右边的总数
                dp[n-1][j][r] = dp[n-1][j+1][getNeededR(grid[n-1][j], k, r)];
            }
        }
        for (int i = n-2; i >= 0; i--) {
            for (int r = 0; r < k; r++) {
                // 下边的总数
                dp[i][m-1][r] = dp[i+1][m-1][getNeededR(grid[i][m-1], k, r)];
            }
        }
        for (int i = n-2; i>=0; i--) {
            for (int j = m-2; j>=0; j--) {
                for (int r = 0; r < k; r++) {
                    dp[i][j][r] = (dp[i+1][j][getNeededR(grid[i][j], k, r)] + dp[i][j+1][getNeededR(grid[i][j], k, r)]) % MOD;
                }
            }
        }

        return dp[0][0][0];
    }

    private int getNeededR(int curNum, int k, int totalR) {
        int r = curNum % k;
        if (r <= totalR) return totalR - r;
        return k + totalR - r;
    }
}