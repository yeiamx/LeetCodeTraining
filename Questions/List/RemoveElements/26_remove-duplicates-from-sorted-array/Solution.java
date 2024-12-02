class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int slow = -1; int fast = 0;
        while (fast < nums.length - 1) {
            if (nums[fast] != nums[fast + 1]) {
                slow = slow + 1;
                nums[slow] = nums[fast];
            } else {
                while (fast < nums.length - 1 && nums[fast] == nums[fast + 1]) fast++;
                if (fast < nums.length) {
                    slow = slow + 1;
                    nums[slow] = nums[fast];
                }
            }
            fast++;
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            slow = slow + 1;
            nums[slow] = nums[nums.length - 1];
        }
        return slow + 1;
    }
}
