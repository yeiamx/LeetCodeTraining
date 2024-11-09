    class Solution {
        public int numDecodings(String s) {
            char[] sArray = s.toCharArray();
            long[] dp = new long[100001];
            long modNum = 1000000007;
            dp[s.length()] = 1;
            for (int i = sArray.length - 1; i >= 0; i--) {
                if (sArray[i] == '0') {
                    dp[i] = 0;
                } else {
                    if (sArray[i] == '*') {
                        dp[i] += 9 * dp[i + 1];
                    } else {
                        dp[i] += dp[i + 1];
                    }
                    if (i < sArray.length - 1) {
                        if (sArray[i] != '*' && sArray[i + 1] != '*' && (sArray[i] - '0')*10 + (sArray[i+1] - '0') <= 26) {
                            dp[i] += dp[i + 2];
                        }
                        if (sArray[i] == '*' && sArray[i + 1] != '*') {
                            if ('0' <= sArray[i + 1] && sArray[i + 1] <= '6') {
                                dp[i] += 2 * dp[i + 2];
                            } else if ('7' <= sArray[i + 1] && sArray[i + 1] <= '9'){
                                dp[i] += dp[i + 2];
                            }
                        }
                        if (sArray[i] != '*' && sArray[i + 1] == '*') {
                            if (sArray[i] == '2') {
                                dp[i] += 6 * dp[i + 2];
                            }
                            if (sArray[i] == '1') {
                                dp[i] += 9 * dp[i + 2];
                            }
                        }
                        if (sArray[i] == '*' && sArray[i + 1] == '*') {
                            dp[i] += 15 * dp[i + 2];
                        }
                    }
                }
                dp[i] = dp[i] % modNum;
            }
            return (int)dp[0];
        }
    }
