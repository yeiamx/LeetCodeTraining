import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1005];
        int[] hash2 = new int[1005];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            hash1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            hash2[nums2[i]]++;
        }
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] > 0 && hash2[i] > 0) {
                int time = Math.min(hash1[i], hash2[i]);
                for (int j = 0; j < time; j++) {
                    res.add(i);
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
