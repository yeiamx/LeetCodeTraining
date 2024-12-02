    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int l = 0; int sum = 0; int r = 0;
            while (r < nums.length && sum + nums[r] < target)
                sum += nums[r++];
            if (r == nums.length && sum < target)
                return 0;

            int ans = r - l + 1;
            for (int i = r; i < nums.length; i++) {
                sum += nums[i];
                for (int j = l; j <= i; j++) {
                    if (sum - nums[j] < target) {
                        l = j;
                        break;
                    } else {
                        sum -= nums[j];
                    }
                }
                ans = Math.min(ans, i - l + 1);
            }
            return ans;
        }
    }
