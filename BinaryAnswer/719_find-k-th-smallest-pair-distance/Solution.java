import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0; int right = nums[nums.length - 1] - nums[0]; int ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (numOfPairsBelowDistance(nums, mid) <= k-1) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    //nums sorted
    //输出nums中小于数对距离distance的数对个数
    public int numOfPairsBelowDistance(int[] nums, int distance) {
        if (nums.length < 2) return 0;
        int l = 0; int r = 1; int k = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] - nums[l] < distance) r++;
            if (r == nums.length) {
                k += (r - l - 1) * (r - l) / 2;
                break;
            } else {
                k += r - l - 1;
                l++;
                if (l == r) r++;
            }
        }
        return k;
    }
}
