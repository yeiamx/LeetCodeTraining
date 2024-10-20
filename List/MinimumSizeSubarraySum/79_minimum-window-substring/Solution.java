import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int start = 0; int end = 0;
        int minStart = 0; int minEnd = -1;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
            if (judgeContainByMap(sMap, tMap)) {
                end = i;
                minEnd = i;
                break;
            }
        }
        if (minEnd < 0) {
            return "";
        }


        while (end < s.length()) {

            while (start <= end) {
                sMap.put(s.charAt(start), sMap.get(s.charAt(start)) - 1);
                if (judgeContainByMap(sMap, tMap)) {
                    start++;
                } else {
                    sMap.put(s.charAt(start), sMap.get(s.charAt(start)) + 1);
                    break;
                }
            }
            if (minEnd - minStart + 1 > end - start + 1) {
                minEnd = end;
                minStart = start;
            }

            end++;
            if (end == s.length()) break;
            if (sMap.containsKey(s.charAt(end))) {
                sMap.put(s.charAt(end), sMap.get(s.charAt(end)) + 1);
            } else {
                sMap.put(s.charAt(end), 1);
            }
        }

        return s.substring(minStart, minEnd + 1);
    }

    //Judge S contains T By hashmap
    private boolean judgeContainByMap(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Character c: tMap.keySet()) {
            if (!sMap.containsKey(c) || sMap.get(c) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
