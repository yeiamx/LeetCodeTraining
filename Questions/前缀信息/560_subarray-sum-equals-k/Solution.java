import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumCountMap = new HashMap<>();
        preSumCountMap.put(0, 1);
        int preSum = 0; int res = 0;
        // Map count 0..i-1 preSum appears count.
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            if (preSumCountMap.containsKey(preSum - k)) {
                res += preSumCountMap.get(preSum - k);
            }

            if (preSumCountMap.containsKey(preSum)) {
                preSumCountMap.put(preSum, preSumCountMap.get(preSum) + 1);
            } else {
                preSumCountMap.put(preSum, 1);
            }
        }
        return res;
    }
}
