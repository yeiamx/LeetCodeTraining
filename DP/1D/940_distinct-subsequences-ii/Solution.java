class Solution {
    public int distinctSubseqII(String s) {
        int modNum = 1000000007;
        char[] sArray = s.toCharArray();
        int[] dp = new int[sArray.length];
        int[] endSize = new int[26];
        dp[0] = 2; endSize[sArray[0] - 'a'] = 1;

        for (int i = 1; i < s.length(); i++) {
            dp[i] = (dp[i - 1] + dp[i - 1]) % modNum;
            dp[i] = (dp[i] - endSize[sArray[i] - 'a'] + modNum) % modNum;
            int newAdd = (dp[i] - dp[i - 1] + modNum) % modNum;
            endSize[sArray[i] - 'a'] = (endSize[sArray[i] - 'a'] + newAdd) % modNum;
        }
        return (dp[s.length() - 1] - 1 + modNum) % modNum;
    }
}
