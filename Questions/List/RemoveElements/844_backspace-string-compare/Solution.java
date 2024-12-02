class Solution {
    public boolean backspaceCompare(String s, String t) {
        int slow1 = -1; int fast1 = 0;
        int slow2 = -1; int fast2 = 0;
        char[] s1 = s.toCharArray(); char[] s2 = t.toCharArray();
        while (fast1 < s1.length) {
            if (s1[fast1] != '#') {
                slow1 = slow1 + 1;
                s1[slow1] = s1[fast1];
            } else {
                while (fast1 < s1.length && s1[fast1] == '#') {
                    fast1++;
                    if (slow1 >= 0)
                        slow1--;
                }
                if (fast1 < s1.length) {
                    slow1 = slow1 + 1;
                    s1[slow1] = s1[fast1];
                }
            }
            fast1++;
        }
        while (fast2 < s2.length) {
            if (s2[fast2] != '#') {
                slow2 = slow2 + 1;
                s2[slow2] = s2[fast2];
            } else {
                while (fast2 < s2.length && s2[fast2] == '#') {
                    fast2++;
                    if (slow2 >= 0)
                        slow2--;
                }
                if (fast2 < s2.length) {
                    slow2 = slow2 + 1;
                    s2[slow2] = s2[fast2];
                }
            }
            fast2++;
        }
        if (slow1 != slow2) return false;
        for (int i = 0; i <= slow1; i++) if (s1[i] != s2[i]) return false;
        return true;
    }
}
