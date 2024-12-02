import java.util.Arrays;

class Solution {

    private static int MAXN = 100001;

    private static int[] deque = new int[MAXN];

    // Define deque deque[head, tail).
    private static int head = 0;

    private static int tail = 0;

    // Define window [l, r).
    private static int l = 0, r = 0;
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; head = 0; tail = 0; l = 0; r = 0;
        Arrays.fill(deque, 0);
        int[] ans = new int[n-k+1]; int index = 0;
        for (int i = 0; i < k; i++) {
            inDeque(nums, i);
        }
        ans[index++] = maxOfWindow(nums);

        for (int L = 1; L <= n - k; L++) {
            l = L;
            r = L + k - 1;
            outDeque();
            inDeque(nums, r);
            ans[index++] = maxOfWindow(nums)
        }
        return ans;
    }

    // Put index of nums[index] into deque.
    private static void inDeque(int[] nums, int index) {
        while (tail > head && nums[deque[tail - 1]] <= nums[index]) tail--;
        deque[tail++] = index;
    }

    // Get expired index out of deque.
    private static void outDeque() {
        while (head < tail && deque[head] < l) head++;
    }

    private static int maxOfWindow(int[] nums) {
        return head < tail ? nums[deque[head]] : 0;
    }
}
