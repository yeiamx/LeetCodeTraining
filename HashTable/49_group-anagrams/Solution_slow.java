import java.util.ArrayList;
import java.util.List;

class Solution_slow {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] grouped = new boolean[strs.length];
        int index = 0;
        while (index < strs.length) {
            if (!grouped[index]) {
                grouped[index] = true;
                List<String> strList = new ArrayList<>();
                strList.add(strs[index]);
                for (int i = index + 1; i < strs.length; i++) {
                    if (!grouped[i] && isAnagram(strs[index], strs[i])) {
                        grouped[i] = true;
                        strList.add(strs[i]);
                    }
                }
                res.add(strList);
            }
            index++;
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0)  {
                return false;
            }
        }
        return true;
    }
}
