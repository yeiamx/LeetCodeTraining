class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(robInRange(nums, 1, nums.length - 1), robInRange(nums, 2, nums.length - 2) + nums[0]);
    }

    private int robInRange(int[] nums, int l, int r) {
        if (l > r) return 0;
        if (l == r) {
            return nums[l];
        }
        if (r == l + 1) {
            return Math.max(nums[l],nums[r]);
        }
        int pre = Math.max(nums[l],nums[l+1]); int prepre = nums[l];
        int res = Integer.MIN_VALUE;
        for (int i = l + 2; i <= r; i++) {
            int cur = Math.max(pre, nums[i] + prepre);
            res = Math.max(res, cur);
            prepre = pre;
            pre = cur;
        }
        return res;
    }
}
