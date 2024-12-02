import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        int len = p.length();
        int[] hashP = new int[26];
        int[] hashWindow = new int[26];
        for (int i = 0; i < p.length(); i++) {
            hashP[p.charAt(i) - 'a']++;
            hashWindow[s.charAt(i) - 'a']++;
        }
        boolean isAnagram = true;
        for (int i = 0; i < 26; i++) {
            if (hashP[i] != hashWindow[i]) {
                isAnagram = false;
                break;
            }
        }
        if (isAnagram) {
            res.add(0);
        }

        int i = 1;
        while (i <= s.length() - len) {
            if (isAnagram) {
                if (s.charAt(i-1) == s.charAt(i+len-1)) {
                    res.add(i);
                }
                else {
                    isAnagram = false;
                    hashWindow[s.charAt(i - 1) - 'a']--;
                    hashWindow[s.charAt(i+len-1) - 'a']++;
                }
            } else {
                hashWindow[s.charAt(i - 1) - 'a']--;
                hashWindow[s.charAt(i+len-1) - 'a']++;
                isAnagram = true;
                for (int j = 0; j < 26; j++) {
                    if (hashP[j] != hashWindow[j]) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) {
                    res.add(i);
                }
            }
            i++;
        }

        return res;
    }
}
