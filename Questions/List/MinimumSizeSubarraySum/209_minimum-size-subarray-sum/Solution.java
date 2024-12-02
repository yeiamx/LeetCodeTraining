    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int start = 0;
            int minLen = nums.length + 1;
            int curSum = 0;
            int end = 0;
            //排除开头的部分end
            for (int i = 0; i < nums.length; i++) {
                curSum += nums[i];
                if (curSum >= target) {
                    end = i;
                    break;
                }
            }
            //数组和小于target
            if (end == 0 && nums[0] < target) {
                return 0;
            }
            while (end < nums.length) {
                if (nums[end] >= target) return 1;
                //确定当前end对应的start
                while (start <= end) {
                    if (curSum - nums[start] >= target) {
                        curSum-=nums[start];
                        start++;
                    } else {
                        break;
                    }
                }
                if (minLen > (end - start + 1)) {
                    minLen = end - start + 1;
                }
                //滑动start和end时勿忘处理窗口和
                curSum-=nums[start];
                start++;
                end++;
                if (end < nums.length)
                    curSum+=nums[end];
            }
            return minLen;
        }
    }
