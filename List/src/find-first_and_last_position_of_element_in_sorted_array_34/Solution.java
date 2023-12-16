package find;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0; int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            //1.
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return right + 1;
    }
}