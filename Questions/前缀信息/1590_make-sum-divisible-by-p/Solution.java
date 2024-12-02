import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        int modAll = 0;
        for (int num : nums) {
            modAll = (modAll + num) % p;
        }
        if (modAll == 0) return 0;

        int res = nums.length; int modCur = 0;
        for (int i = 0; i < nums.length; i++) {
            modCur = (modCur + nums[i]) % p;
            int modK = modCur >= modAll ? modCur - modAll : modCur + p - modAll;
            if (indexMap.containsKey(modK)) {
                res = Math.min(res, i - indexMap.get(modK));
            }

            indexMap.put(modCur, i);
        }

        return res == nums.length ? -1 : res;
    }
}
