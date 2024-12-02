class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // preSum[i] = sum[0..i+1]
        long[] preSum = new long[n+1];
        int h = 0; int t = 0;
        // Record index of preSum[]
        int[] deque = new int[n+1];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
        deque[t++] = 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            //Find possible prefix using deque.
            while (h < t && preSum[i+1] - k >= preSum[deque[h]]) {
                ans = Math.min(ans, i + 1 - deque[h++]);
            }
            //Add preSum[i+1] into deque.
            while (h < t && preSum[deque[t-1]] >= preSum[i+1]) t--;
            deque[t++] = i + 1;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

