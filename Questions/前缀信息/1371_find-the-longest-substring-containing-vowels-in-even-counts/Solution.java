import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);

        int res = 0; int status = 0;
        for (int i = 0; i < s.length(); i++) {
            int vowelNum = vowelToNum(s.charAt(i));
            if (vowelNum > 0) {
                if ((status & vowelNum) > 0) {
                    status -= vowelNum;
                } else {
                    status += vowelNum;
                }
            }

            if (indexMap.containsKey(status)) {
                res = Math.max(res, i - indexMap.get(status));
            }
            if (!indexMap.containsKey(status)) {
                indexMap.put(status, i);
            }
        }

        return res;
    }

    private int vowelToNum(char ch) {
        if (ch == 'a') return 16;
        if (ch == 'e') return 8;
        if (ch == 'i') return 4;
        if (ch == 'o') return 2;
        if (ch == 'u') return 1;
        return -1;
    }
}
