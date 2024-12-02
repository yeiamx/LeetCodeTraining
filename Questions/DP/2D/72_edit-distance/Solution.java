class Solution {
    public int minDistance(String word1, String word2) {
        return minDistanceWithCost(word1.toCharArray(), word2.toCharArray(), 1, 1 ,1);
    }

    private int minDistanceWithCost(char[] word1, char[] word2, int a, int b, int c) {
        int n = word1.length;
        int m = word2.length;
        int[] dp = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            dp[j] = j;
        }
        int tmp, leftUp;
        for (int i = 1; i <= n; i++) {
            dp[0] = i; leftUp = i - 1;
            for (int j = 1; j <= m; j++) {
                tmp = dp[j];
                dp[j] += b;
                dp[j] = Math.min(dp[j - 1] + a, dp[j]);
                if (word1[i - 1] == word2[j - 1]) {
                    dp[j] = Math.min(leftUp, dp[j]);
                } else {
                    dp[j] = Math.min(leftUp + c, dp[j]);
                }
                leftUp = tmp;
            }
        }
        return dp[m];
    }
}
