class Solution {
    public int longestWPI(int[] hours) {

        int n = hours.length;
        HashMap<Integer, Integer> preSumIndexMap = new HashMap<>();
        preSumIndexMap.put(0, -1);

        int res = 0;
        for (int i = 0; i < n; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        for (int i = 0, preSum = 0; i < n; i++) {
            preSum += hours[i];
            if (preSum > 0) {
                res = i + 1;
            }

            else if (preSumIndexMap.containsKey(preSum - 1)) {
                res = Math.max(res, i - preSumIndexMap.get(preSum - 1));
            }

            if (!preSumIndexMap.containsKey(preSum)) {
                preSumIndexMap.put(preSum, i);
            }
        }
        return res;
    }
}
