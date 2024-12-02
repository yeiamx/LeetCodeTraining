import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);

            if (!strMap.containsKey(key)) {
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                strMap.put(key, strList);
            } else {
                strMap.get(key).add(strs[i]);
            }
        }
        for (String key : strMap.keySet()) {
            res.add(strMap.get(key));
        }
        return res;
    }

}
