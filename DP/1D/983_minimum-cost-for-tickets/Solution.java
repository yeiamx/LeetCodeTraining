import java.util.Arrays;

class Solution {
    public static int[] duration = new int[]{1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        // days长度最大为365
        int[] dp = new int[366];

        for (int i = days.length - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int k = 0; k < duration.length; k++) {
                int cost = costs[k];
                int j = i;
                while (j < days.length && days[j] < days[i] + duration[k]) j++;
                cost += dp[j];
                minCost = Math.min(minCost, cost);
            }
            dp[i] = minCost;
        }

        return dp[0];
    }
}
