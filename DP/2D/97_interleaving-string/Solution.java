    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n = s1.length(); int m = s2.length();
            if (s3.length() != n + m) return false;
            boolean[] dp = new boolean[m + 1];

            dp[0] = true;
            for (int j = 1; j <= m; j++) {
                if (s2.charAt(j-1) == s3.charAt(j-1)) {
                    dp[j] = true;
                } else {
                    break;
                }
            }

            for (int i = 1; i <= n; i++) {
                dp[0] = dp[0] && s1.charAt(i-1)==s3.charAt(i-1);
                for (int j = 1; j <= m; j++) {
                    dp[j]= (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[j]) || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[j-1]);
                }
            }
            return dp[m];
        }
    }
