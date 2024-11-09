import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int N = nums1.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                int sum = nums1[i] + nums2[j];
                if (hashMap.containsKey(sum)) {
                    hashMap.put(sum, hashMap.get(sum) + 1);
                } else {
                    hashMap.put(sum, 1);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                int sum = nums3[i] + nums4[j];
                if (hashMap.containsKey(-sum)) {
                    count += hashMap.get(-sum);
                }
            }
        }
        return count;
    }
}
