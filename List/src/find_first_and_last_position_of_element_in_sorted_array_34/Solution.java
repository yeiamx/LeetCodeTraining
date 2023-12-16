package find_first_and_last_position_of_element_in_sorted_array_34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = findLeftBorder(nums, target);
        int rightBorder = findRightBorder(nums, target);
        if (leftBorder == -1 || rightBorder == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{leftBorder, rightBorder};
    }

    private int findLeftBorder(int[] nums, int target) {
        int leftBorder = -1;
        int left = 0; int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] == target) {
                leftBorder = middle;
                right = middle - 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    private int findRightBorder(int[] nums, int target) {
        int rightBorder = -1;
        int left = 0; int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] == target) {
                rightBorder = middle;
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return rightBorder;
    }
}