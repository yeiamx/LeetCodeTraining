import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        while (i <= nums.length - 3) {
            if (nums[i] > 0) return res;
            int left = i + 1; int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]); triplet.add(nums[left]); triplet.add(nums[right]);
                    res.add(triplet);
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                }else if (sum > 0) {
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                } else {
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                }
            }
            i++;
            while (i <= nums.length - 3 && nums[i] == nums[i - 1]) i++;
        }
        return res;
    }
}
