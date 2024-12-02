class Solution {
    public void moveZeroes(int[] nums) {
        int slow = -1; int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                slow = slow + 1;
                nums[slow] = nums[fast];
            } else {
                while (fast < nums.length && nums[fast] == 0) fast++;
                if (fast < nums.length) {
                    slow = slow + 1;
                    nums[slow] = nums[fast];
                }
            }
            fast++;
        }
        for (int i = slow + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
        return;
    }
}
