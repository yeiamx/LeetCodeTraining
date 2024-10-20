import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1) {
            return 1;
        }
        int MAX_TYPE = 2;
        int start = 0; int end = 0;
        int cur_len = 0; int max_len = -1;
        Map<Integer, Integer> typeMap = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            cur_len++;
            if (typeMap.containsKey(fruits[i])) {
                typeMap.put(fruits[i], typeMap.get(fruits[i]) + 1);
            } else {
                typeMap.put(fruits[i], 1);
            }
            if (typeMap.keySet().size() > MAX_TYPE) {
                typeMap.remove(fruits[i]);
                end = i;
                break;
            }
        }
        if (cur_len == fruits.length && end == 0) {
            return fruits.length;
        }
        max_len = cur_len - 1;
        while (end < fruits.length) {
            if (typeMap.containsKey(fruits[end])) {
                typeMap.put(fruits[end], typeMap.get(fruits[end]) + 1);
            } else {
                typeMap.put(fruits[end], 1);
            }
            while (typeMap.keySet().size() > MAX_TYPE) {
                typeMap.put(fruits[start], typeMap.get(fruits[start]) - 1);
                if (typeMap.get(fruits[start]) == 0) {
                    typeMap.remove(fruits[start]);
                }
                start++;
                cur_len--;
            }
            if (cur_len > max_len) {
                max_len = cur_len;
            }
            end++;
            cur_len++;
        }
        return max_len;
    }
}
