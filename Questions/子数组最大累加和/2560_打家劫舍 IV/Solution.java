class Solution {
    public int minCapability(int[] nums, int k) {
        int min = nums[0]; int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        int left = min; int right = max; int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (maxRobberNum(nums, mid) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int maxRobberNum1(int[] nums, int ability) {
        if (nums.length == 1) return ability >= nums[0] ? 1 : 0;
        if (nums.length == 2) return ability >= nums[0] || ability >= nums[1] ? 1 : 0;
        int[] dp = new int[nums.length];
        dp[0] = ability >= nums[0] ? 1 : 0; dp[1] = ability >= nums[0] || ability >= nums[1] ? 1 : 0;
        for (int i = 2; i < nums.length; i++) {
            dp[i] = dp[i - 1];
            if (nums[i] <= ability) {
                dp[i] = Math.max(dp[i], dp[i-2] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public int maxRobberNum(int[] nums, int ability) {
        int index = 0; int k = 0;
        while (index < nums.length) {
            if (nums[index] <= ability) {
                k++; index+=2;
            } else {
                index++;
            }
        }
        return k;
    }
}
