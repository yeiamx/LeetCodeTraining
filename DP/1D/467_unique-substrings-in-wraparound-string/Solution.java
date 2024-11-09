class Solution {
    public int findSubstringInWraproundString(String s) {
        char[] sArray = s.toCharArray();
        int[] dp = new int[sArray.length];
        int[] longestSubStringByAlphabet = new int[26];

        dp[0] = 1; longestSubStringByAlphabet[sArray[0] - 'a'] = 1;

        for (int i = 1; i < sArray.length; i++) {
            if ((sArray[i-1] + 1 - 'a') % 26 != (sArray[i] - 'a')) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            longestSubStringByAlphabet[sArray[i] - 'a'] = Math.max(longestSubStringByAlphabet[sArray[i] - 'a'], dp[i]);
        }

        int sum = 0;
        for (int i=0; i < 26; i++) sum+=longestSubStringByAlphabet[i];
        return sum;
    }


}
