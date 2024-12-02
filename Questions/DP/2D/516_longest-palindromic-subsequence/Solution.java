class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int l = n - 1; l >= 0; l--) {
            dp[l] = 1;
            if (l < n - 1) {
                dp[l + 1] = s.charAt(l) == s.charAt(l+1) ? 2 : 1;
            }
            int tmp; int leftDown = 1;
            for (int j = l + 2; j < n; j++) {
                tmp = dp[j];
                if (s.charAt(l) == s.charAt(j)) {
                    dp[j] = leftDown + 2;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                leftDown = tmp;
            }
        }
        return dp[n - 1];
    }
}
