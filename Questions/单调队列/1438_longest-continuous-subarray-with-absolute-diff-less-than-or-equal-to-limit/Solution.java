import java.util.Arrays;

class Solution {
    private static int MAXN = 100001;

    private static int[] maxDeque = new int[MAXN];

    // Define deque deque[head, tail).
    private static int maxHead = 0;

    private static int maxTail = 0;

    private static int[] minDeque = new int[MAXN];

    // Define deque deque[head, tail).
    private static int minHead = 0;

    private static int minTail = 0;

    // Define window [l, r).
    private static int l = 0, r = 0;

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        l = 0; r = 0;
        maxHead = 0; maxTail = 0;
        Arrays.fill(maxDeque, 0);
        minHead = 0; minTail = 0;
        Arrays.fill(minDeque, 0);

        int ans = 0;
        for (int L = 0; L < n; L++) {
            l = L;
            outDeque();
            // Search R start from r makes Array[L, R] unsatisfied.
            int R = r;
            while (R < n) {
                inDeque(nums, R);
                if (maxOfWindow(nums) - minOfWindow(nums) > limit) {
                    break;
                }
                R++;
            }
            r = R;
            ans = Math.max(ans ,r - l);
        }
        return ans;
    }

    // Put index of nums[index] into deque.
    private static void inDeque(int[] nums, int index) {
        while (maxTail > maxHead && nums[maxDeque[maxTail - 1]] <= nums[index]) maxTail--;
        maxDeque[maxTail++] = index;
        while (minTail > minHead && nums[minDeque[minTail - 1]] >= nums[index]) minTail--;
        minDeque[minTail++] = index;
    }

    // Get expired index out of deque.
    private static void outDeque() {
        while (maxHead < maxTail && maxDeque[maxHead] < l) maxHead++;
        while (minHead < minTail && minDeque[minHead] < l) minHead++;
    }
    private static int maxOfWindow(int[] nums) {
        return maxHead < maxTail ? nums[maxDeque[maxHead]] : 0;
    }

    private static int minOfWindow(int[] nums) {
        return minHead < minTail ? nums[minDeque[minHead]] : 0;
    }

}
