import java.util.Arrays;

class Solution {
    public int longestSubstring(String s, int k) {
        int[] status = new int[256];
        int ans = 0;
        for (int T = 1; T <= 26; T++) {
            int typesInWindow = 0;
            // 记录窗口中有几种字符的数量>=k.
            int satisfiedLetter = 0;
            Arrays.fill(status, 0);
            for (int i = 0, l = 0; i < s.length(); i++) {
                status[s.charAt(i)]++;
                if (status[s.charAt(i)] == 1) {
                    typesInWindow++;
                }
                if (status[s.charAt(i)] == k) {
                    satisfiedLetter++;
                }

                if (typesInWindow > T) {
                    while (typesInWindow > T && l <= i) {
                        status[s.charAt(l)]--;
                        if (status[s.charAt(l)] == 0) {
                            typesInWindow--;
                        }
                        if (status[s.charAt(l)] == k - 1) {
                            satisfiedLetter--;
                        }
                        l++;
                    }
                }

                //[l..i] = longest window only contains T types ended by i.
                if (typesInWindow == T) {
                    if (satisfiedLetter == T) {
                        ans = Math.max(ans, i - l + 1);
                    }
                }
            }
        }
        return ans;
    }
}
