class NumArray {

    private int[] nums;

    private int[] preSum;
    public NumArray(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length + 1];
        computePreSum();
    }

    private void computePreSum() {
        int curPreSum = 0;
        for (int i = 1; i < preSum.length; i++) {
            curPreSum += nums[i - 1];
            preSum[i] = curPreSum;
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */