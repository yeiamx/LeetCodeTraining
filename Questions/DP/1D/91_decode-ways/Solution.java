class Solution {
    public int numDecodings(String s) {
        char[] sArray = s.toCharArray();
        int[] dp = new int[101];

        for (int i = sArray.length - 1; i >= 0; i--) {
            if (sArray[i] == '0') {
                dp[i] = 0;
            } else {
                int try1 = 0; int try2 = 0;
                try1 = i + 1 < sArray.length ? dp[i + 1] : 1;
                if (i + 1 < sArray.length && (sArray[i] - '0')*10 + (sArray[i+1] - '0') <= 26) {
                    try2 = i + 2 < sArray.length ? dp[i + 2] : 1;
                }
                dp[i] = try2 + try1;
            }
        }
        return dp[0];
    }
}
