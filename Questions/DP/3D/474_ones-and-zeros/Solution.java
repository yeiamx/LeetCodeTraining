class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int[] zeroesAndOnes = getZeroesAndOnes(strs[strs.length - 1]);
//        for (int z = 0; z <= zeroesAndOnes[0]; z++) {
//            for (int o = 0; o <= zeroesAndOnes[1]; o++) {
//                dp[z][o] = 1;
//            }
//        }

        for (int i = strs.length - 1; i >= 1; i--) {
            zeroesAndOnes = getZeroesAndOnes(strs[i]);
            for (int z = m; z >= zeroesAndOnes[0]; z--) {
                for (int o = n; o >= zeroesAndOnes[1]; o--) {
                    dp[z][o] = Math.max(dp[z][o], 1 + dp[z-zeroesAndOnes[0]][o - zeroesAndOnes[1]]);
                }
            }
        }

        zeroesAndOnes = getZeroesAndOnes(strs[0]);
        if (m-zeroesAndOnes[0] >= 0 && n - zeroesAndOnes[1] >= 0)
            dp[m][n] = Math.max(dp[m][n], 1 + dp[m-zeroesAndOnes[0]][n - zeroesAndOnes[1]]);


        return dp[m][n];
    }
    private int[] getZeroesAndOnes(String s) {
        int[] res = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') {
                res[0]++;
            }
            if (c == '1') {
                res[1]++;
            }
        }
        return res;
    }
}