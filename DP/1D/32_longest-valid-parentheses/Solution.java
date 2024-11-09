class Solution {
    public int longestValidParentheses(String s) {
        char[] sArray = s.toCharArray();
        //dp[i] = S中以S[i - 1]（第i个字符）结尾的子串的最大合法长度
        int[] dp = new int[sArray.length + 1];
        dp[0] = 0;
        int max = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == '(') {
                dp[i + 1] = 0;
            } else {
                if (i - dp[i] - 1 < 0 || sArray[i - dp[i] - 1] == ')') {
                    dp[i + 1] = 0;
                } else {
                    // k = dp[i]
                    // i-k-1 i-k [i-k+1...i] i+1
                    dp[i + 1] = 2 + dp[i] + dp[i - dp[i] - 1];
                }
            }
            max = Math.max(dp[i + 1], max);
        }

        return max;
    }
}
