class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        int[][] directions = {{-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[0][i][j] = 1;
            }
        }

        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] direction : directions) {
                        if (i + direction[0] >= 0 && i + direction[0] < n && j + direction[1] >= 0 && j + direction[1] < n) {
                            dp[step][i][j] += (dp[step-1][i+direction[0]][j+direction[1]]) / 8 ;
                        }
                    }
                }
            }
        }

            return dp[k][row][column];
    }
}