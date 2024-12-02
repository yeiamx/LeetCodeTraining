class Solution {
    public int[] getMaxMatrix(int[][] matrix) {
        int res = Integer.MIN_VALUE;
        int n = matrix.length; int m = matrix[0].length;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        int[] nums = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] maxMatrix =  getMaxMatrixBetweenLines(matrix, i, j, nums);
                if (maxMatrix[4] > res) {
                    x1 = maxMatrix[0]; y1 = maxMatrix[1];
                    x2 = maxMatrix[2]; y2 = maxMatrix[3];
                    res = maxMatrix[4];
                }
            }
        }


        return new int[]{x1, y1, x2, y2};
    }

    // Compute Max Matrix which only contains line i to line j.(i <= j)
    // return [x1, y1, x2, y2, maxSum]
    public int[] getMaxMatrixBetweenLines(int[][] matrix, int i, int j, int[] nums) {
        int[] res = new int[5];
        res[0] = i; res[2] = j;
        int m = matrix[0].length;
        for (int y = 0; y < m; y++) nums[y] = matrix[i][y];
        for (int x = i + 1; x <= j; x++) {
            for (int y = 0; y < m; y++) {
                nums[y] += matrix[x][y];
            }
        }

        int[] subArray = maxSubArray(nums);
        res[1] = subArray[0]; res[3] = subArray[1]; res[4] = subArray[2];
        return res;
    }

    // return sub array [i1, i2, maxSum]
    public int[] maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int i1 = 0; int i2 = 0;
        int curi1 = 0; int curi2 = 0;
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                curi1 = i; curi2 = i;
                dp[i] = nums[i];
            } else {
                curi2 = i;
                dp[i] = dp[i-1] + nums[i];
            }

            if (dp[i] > res) {
                res = dp[i];
                i1 = curi1;
                i2 = curi2;
            }
        }
        return new int[]{i1, i2, res};
    }
}
