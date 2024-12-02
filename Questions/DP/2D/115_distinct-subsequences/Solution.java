class Solution {
    public static int MOD = 1000000007;
    public int numDistinct(String s, String t) {
        int n = s.length(); int m = t.length();
        int[] dp = new int[m + 1];
        int tmp, leftUp;
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            leftUp = dp[0];
            for (int j = 1; j <= m; j++) {
                tmp = dp[j];
                dp[j] = 0;
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] = leftUp;
                }
                dp[j]  = (dp[j] + tmp) % MOD;
                leftUp = tmp;
            }
        }
        return dp[m];
    }
}
