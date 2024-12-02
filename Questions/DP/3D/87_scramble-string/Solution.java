class Solution {
    public boolean isScrambleRecursive(String s1, String s2) {
        return f(s1.toCharArray(), s2.toCharArray(), 0, 0, s1.length());
    }


    public boolean isScramble(String s1, String s2) {
        char[] s = s1.toCharArray(); char[] t = s2.toCharArray();
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s[i] == t[j]) {
                    dp[i][j][1] = true;
                }
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                for (int j = 0; j <= n-len; j++) {
                    //对应
                    for (int k = 1; k < len; k++) {
                        if (dp[i][j][len]) break;
                        if (dp[i][j][k] && dp[i+k][j+k][len-k]) {
                            dp[i][j][len] = true;
                        }
                    }
                    //交错
                    for (int k = 1; k < len; k++) {
                        if (dp[i][j][len]) break;
                        if (dp[i][j+len-k][k] && dp[i+k][j][len-k]){
                            dp[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }


    private boolean f(char[] s, char[] t, int l1, int l2, int len) {
        if (len == 1) {
            return s[l1] == t[l2];
        }
        //对应
        for (int k = 1; k < len; k++) {
            if (f(s, t, l1, l2, k) && f(s, t, l1+k, l2+k, len - k)) {
                return true;
            }
        }
        //交错
        for (int k = 1; k < len; k++) {
            if (f(s, t, l1, l2 + len-k, k) && f(s, t, l1+k, l2, len - k)) {
                return true;
            }
        }
        return false;
    }
}
