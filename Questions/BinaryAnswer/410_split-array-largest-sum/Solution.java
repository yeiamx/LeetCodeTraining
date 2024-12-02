class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0; int ans = -1;
        for (int i = 0; i < nums.length; i++) sum+= nums[i];
        long l = 0; long r =sum;
        // 本质是去找一个区间的左边界
        while (l <= r) {
            int ansMid = l + ((r - l) >> 1);
            if (minPartCountOfLimitPartSum(nums, ansMid) <= k) {
                r = ansMid - 1;
                ans = ansMid;
            } else {
                l = ansMid + 1;
            }

        }
        return (int)ans;
    }

    private int minPartCountOfLimitPartSum(int[] nums, long limit) {
        int part = 1;
        long curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > limit) return Integer.MAX_VALUE;
            curSum += nums[i];
            if (curSum > limit) {
                curSum = nums[i];
                part++;
            }
        }
        return part;
    }
}
