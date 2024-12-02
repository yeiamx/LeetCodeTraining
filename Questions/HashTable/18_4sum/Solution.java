import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int a = 0; int b = 1;
        while (a <= nums.length - 4) {
            if (nums[a] > target && (target>=0 || nums[a]>=0)) return res;
            b = a + 1;
            while (b <= nums.length - 3) {
                int left = b + 1; int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[a] + nums[b] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> quads = new ArrayList<>();
                        quads.add(nums[a]); quads.add(nums[b]); quads.add(nums[left]); quads.add(nums[right]);
                        res.add(quads);
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                    }else if (sum > target) {
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    } else {
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                    }
                }

                b++;
                while (b <= nums.length - 3 && nums[b] == nums[b - 1]) b++;
            }
            a++;
            while (a <= nums.length - 4 && nums[a] == nums[a - 1]) a++;
        }
        return res;
    }
}
