class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int loopTime = n / 2;
        boolean fitCenter = n % 2 == 1;
        int curNum = 0;
        for (int i = 0; i < loopTime; i++) {
            int windowLen = n - i * 2 - 1;
            int curX = i; int curY = i;

            for (int index = curY; index < curY + windowLen; index++) {
                res[curX][index] = ++curNum;
            }
            curY = curY + windowLen;

            for (int index = curX; index < curX + windowLen; index++) {
                res[index][curY] = ++curNum;
            }
            curX = curX + windowLen;

            for (int index = curY; index >= curY - windowLen + 1; index--) {
                res[curX][index] = ++curNum;
            }
            curY = curY - windowLen;

            for (int index = curX; index >= curX - windowLen + 1; index--) {
                res[index][curY] = ++curNum;
            }


        }
        if (fitCenter) {
            res[n/2][n/2] = ++curNum;
        }
        return res;
    }
}