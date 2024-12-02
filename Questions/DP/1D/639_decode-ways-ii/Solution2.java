    class Solution2 {
        public int numDecodings(String s) {
            char[] sArray = s.toCharArray();
            //long[] dp = new long[100001];
            long modNum = 1000000007;
            //dp[s.length()] = 1;
            // cur last1 last2
            // Update cur by last1 & last2
            long cur = 0; long last1 = 1; long last2 = 1;
            for (int i = sArray.length - 1; i >= 0; i--) {
                cur = 0;
                if (sArray[i] == '0') {
                    cur = 0;
                } else {
                    if (sArray[i] == '*') {
                        cur += 9 * last1;
                    } else {
                        cur += last1;
                    }
                    if (i < sArray.length - 1) {
                        if (sArray[i] != '*' && sArray[i + 1] != '*' && (sArray[i] - '0')*10 + (sArray[i+1] - '0') <= 26) {
                            cur += last2;
                        }
                        if (sArray[i] == '*' && sArray[i + 1] != '*') {
                            if ('0' <= sArray[i + 1] && sArray[i + 1] <= '6') {
                                cur += 2 * last2;
                            } else if ('7' <= sArray[i + 1] && sArray[i + 1] <= '9'){
                                cur += last2;
                            }
                        }
                        if (sArray[i] != '*' && sArray[i + 1] == '*') {
                            if (sArray[i] == '2') {
                                cur += 6 * last2;
                            }
                            if (sArray[i] == '1') {
                                cur += 9 * last2;
                            }
                        }
                        if (sArray[i] == '*' && sArray[i + 1] == '*') {
                            cur += 15 * last2;
                        }
                    }
                }

                cur = cur % modNum;
                last2 = last1;
                last1 = cur;
            }
            return (int)cur;
        }
    }
