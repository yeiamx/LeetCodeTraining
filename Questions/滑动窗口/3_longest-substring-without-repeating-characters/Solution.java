import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        int[] lastIndex = new int[256];
        int[] status = new int[256];
        Arrays.fill(lastIndex, -1);

        // Record r. [0..r] unrepeated. And record last index of [0..r]
        int r = -1;
        for (int i = 0; i < s.length(); i++) {
            if (status[s.charAt(i)] == 0) {
                status[s.charAt(i)]++;
                lastIndex[s.charAt(i)] = i;
            } else {
                r = i - 1;
                break;
            }
        }
        // Whole s unrepeated.
        if (r < 0) return s.length();

        int l = 0; int ans = r - l + 1;
        for (int i = r + 1; i < s.length(); i++) {
            if (status[s.charAt(i)] != 0) {
                int k = lastIndex[s.charAt(i)];
                for (int j = l; j <= k; j++) status[s.charAt(j)]--;
                l = k + 1;
            }
            status[s.charAt(i)]++;
            lastIndex[s.charAt(i)] = i;
            ans = Math.max(ans, i - l + 1);
        }

        return ans;
    }
}
