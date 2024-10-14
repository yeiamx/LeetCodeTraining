class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = -1; int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                slow = slow + 1;
                nums[slow] = nums[fast];
            } else {
                while (fast < nums.length && nums[fast] == val) fast++;
                if (fast < nums.length) {
                    slow = slow + 1;
                    nums[slow] = nums[fast];
                }
            }
            fast++;
        }
        return slow + 1;
    }
}
