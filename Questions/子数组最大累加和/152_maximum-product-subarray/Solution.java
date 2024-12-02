class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0]; min[0] = nums[0];
        int ans = max[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                max[i] = 0;
                min[i] = 0;
            } else if (nums[i] > 0) {
                max[i] = Math.max(nums[i], nums[i] * max[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * min[i - 1]);
            } else {
                max[i] = Math.max(nums[i], nums[i] * min[i - 1]);
                min[i] = Math.min(nums[i], nums[i] * max[i - 1]);
            }

            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
