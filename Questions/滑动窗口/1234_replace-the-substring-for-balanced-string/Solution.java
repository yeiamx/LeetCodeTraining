class Solution {
    public int balancedString(String s) {
        int[] sStatus = new int[256]; int[] tStatus = new int[256];
        int[] count = new int[4]; int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Q') count[0]++;
            if (s.charAt(i) == 'W') count[1]++;
            if (s.charAt(i) == 'E') count[2]++;
            if (s.charAt(i) == 'R') count[3]++;
        }
        if (count[0] == count[1] && count[1] == count[2] && count[2] == count[3]) return 0;
        int lettersNeedToCover = 0;

        for (int j = 0; j < count[0] - n / 4; j++) {tStatus['Q']++; lettersNeedToCover++;}
        for (int j = 0; j < count[1] - n / 4; j++) {tStatus['W']++; lettersNeedToCover++;}
        for (int j = 0; j < count[2] - n / 4; j++) {tStatus['E']++; lettersNeedToCover++;}
        for (int j = 0; j < count[3] - n / 4; j++) {tStatus['R']++; lettersNeedToCover++;}



        int l = 0; int minLen = 0;
        for (int i = 0; i < s.length(); i++) {
            sStatus[s.charAt(i)]++;
            if (lettersNeedToCover > 0) {
                minLen++;
                if (tStatus[s.charAt(i)] > 0 && sStatus[s.charAt(i)] - 1 < tStatus[s.charAt(i)]) {
                    lettersNeedToCover--;
                }
            }
            if (lettersNeedToCover == 0) {// [l..i-1] is min window ended by i-1
                while (l < i) {// Check if can abandon s[l]
                    if (tStatus[s.charAt(l)] > 0 && sStatus[s.charAt(l)] == tStatus[s.charAt(l)]) {
                        // if cant [L, i] is ans of i.
                        break;
                    }
                    if (tStatus[s.charAt(l)] != 0)
                        sStatus[s.charAt(l)]--;
                    l++;
                }
                if (i - l + 1 < minLen) {
                    minLen = i - l + 1;
                }
            }
        }
        return minLen;

    }
}
