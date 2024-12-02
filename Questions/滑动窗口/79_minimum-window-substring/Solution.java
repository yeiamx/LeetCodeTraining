import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public String minWindow(String s, String t) {
        int[] sStatus = new int[256]; int[] tStatus = new int[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tStatus[c]++;
        }
        int lettersNeedToCover = t.length();
        int l = 0; int minLen = 0; int minStart = 0;
        for (int i = 0; i < s.length(); i++) {
            sStatus[s.charAt(i)]++;
            if (lettersNeedToCover > 0) {
                minLen++;
                if (tStatus[s.charAt(i)] > 0 && sStatus[s.charAt(i)] - 1 < tStatus[s.charAt(i)]) {
                    lettersNeedToCover--;
                }
            }
            if (lettersNeedToCover == 0) {// [l..i-1] is min window ended by i-1
                while (l < i) {// Check if can abandon s[l]; Dont use for loop, because then l cant reach i.
                    if (tStatus[s.charAt(l)] > 0 && sStatus[s.charAt(l)] == tStatus[s.charAt(l)]) {
                        // if cant [L, i] is ans of i.
                        break;
                    }
                    if (tStatus[s.charAt(l)] != 0)
                        sStatus[s.charAt(l)]--;
                    l++;
                }
                if (i - l + 1 < minLen) {
                    minStart = l;
                    minLen = i - l + 1;
                }
            }
        }
        return lettersNeedToCover == 0 ? s.substring(minStart, minStart + minLen) : "";
    }

//    public String minWindow2(String s, String t) {
//        Set<Character> lettersInT = new HashSet<>();
//        int[] sStatus = new int[256]; int[] tStatus = new int[256];
//
//        for (int i = 0; i < t.length(); i++) {
//            char c = t.charAt(i);
//            lettersInT.add(c);
//            tStatus[c]++;
//        }
//        int lettersNeedToCover = t.length();
//        //Find first r makes s[0..r] contains t
//        int r = -1;
//        for (int i = 0; i < s.length(); i++) {
//            if (lettersInT.contains(s.charAt(i))) {
//                sStatus[s.charAt(i)]++;
//                if (sStatus[s.charAt(i)] <= tStatus[s.charAt(i)]) {
//                    lettersNeedToCover--;
//                    if (lettersNeedToCover == 0) {
//                        r = i;
//                        break;
//                    }
//                }
//            }
//        }
//        // Cant cover
//        if (r < 0)
//            return "";
//        // Find ans l when tail r
//        int l = 0;
//        for (int i = 0; i <= r; i++) {
//            l = i;
//            // Check if we can abandon S[i]
//            if (lettersInT.contains(s.charAt(i))) {
//                if (sStatus[s.charAt(i)] > tStatus[s.charAt(i)]) {
//                    sStatus[s.charAt(i)]--;
//                } else {
//                    break;
//                }
//            }
//        }
//        int minLen = r - l + 1; int minStart = l;
//        for (int i = r + 1; i < s.length(); i++) {
//            sStatus[s.charAt(i)]++;
//            for (int j = l; j <= i; j++) {
//                l = j;
//                // Check if we can abandon letter[j]
//                if (lettersInT.contains(s.charAt(j))) {
//                    if (sStatus[s.charAt(j)] > tStatus[s.charAt(j)]) {
//                        sStatus[s.charAt(j)]--;
//                    } else {
//                        break;
//                    }
//                }
//            }
//            if (i - l + 1 < minLen) {
//                minStart = l;
//                minLen = i - l + 1;
//            }
//        }
//        return s.substring(minStart, minStart + minLen);
//    }
}
