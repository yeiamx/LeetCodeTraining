class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) return nums[0];
        int allSum = nums[0]; int preMax = nums[0]; int preMin = nums[0];
        int minSum = nums[0]; int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            allSum += nums[i];
            int curMax = Math.max(nums[i], preMax+nums[i]);
            maxSum = Math.max(maxSum, curMax);
            preMax = curMax;

            int curMin = Math.min(nums[i], preMin+nums[i]);
            minSum = Math.min(minSum, curMin);
            preMin = curMin;
        }
        return allSum == minSum ? maxSum : Math.max(maxSum, allSum - minSum);
    }
}
