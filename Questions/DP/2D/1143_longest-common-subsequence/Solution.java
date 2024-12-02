class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1; char[] s2;
        if (text1.length() > text2.length()) {
            s1 = text1.toCharArray();
            s2 = text2.toCharArray();
        } else {
            s1 = text2.toCharArray();
            s2 = text1.toCharArray();
        }
        int m = s1.length; int n = s2.length;

        int[] dp = new int[n+1];
        for (int i = 1; i <= m; i++) {
            int tmp = 0; int leftUp = tmp;
            for (int j = 1; j <= n; j++) {
                tmp = dp[j];
                if (s1[i-1] == s2[j-1]) {
                    dp[j] = leftUp + 1;
                } else {
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }

                leftUp = tmp;
            }
        }
        return dp[n];
    }
}
