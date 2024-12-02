class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysLessThanKDistinct(nums, k) - subarraysLessThanKDistinct(nums, k - 1);
    }

    public int subarraysLessThanKDistinct(int[] nums ,int k) {
        if (k == 0) return 0;
        int res = 0; int[] status = new int[200001];
        for (int i = 0, l = 0, currentType = 0; i < nums.length; i++) {
            status[nums[i]]++;
            if (status[nums[i]] == 1) {
                currentType++;
            }

            if (currentType <= k) {
                res += i - l + 1;
                continue;
            }

            // [l..i-1] is the longest window contains k types ended by i-1
            // Add nums[i] makes type in [l..i] = k + 1.
            while (l < i && currentType > k) { // Abandon nums[L] until [L + 1.. i] types = k.
                status[nums[l]]--;
                if (status[nums[l]] == 0) {
                    currentType--;
                }
                l++;
            }
            res += i - l + 1;

        }
        return res;
    }
}
