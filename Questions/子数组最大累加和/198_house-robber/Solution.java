class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int pre = Math.max(nums[0],nums[1]); int prepre = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(pre, nums[i] + prepre);
            res = Math.max(res, cur);
            prepre = pre;
            pre = cur;
        }
        return res;
    }
}
