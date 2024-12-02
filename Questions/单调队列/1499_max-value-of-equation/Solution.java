import java.util.Arrays;

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int[] deque = new int[n];
        int h = 0, t = 0;
        int ans = Integer.MIN_VALUE;
        deque[t++] = 0;
        for (int i = 1; i < n; i++) {
            // Abandon all points with uns dis from head
            while (h < t && points[i][0] - points[deque[h]][0] > k) h++;
            if (h < t) {
                ans = Math.max(ans, points[i][0] + points[i][1] + points[deque[h]][1] - points[deque[h]][0]);
            }
            // Add yi - xi into deque.
            while (h < t && points[deque[t-1]][1] - points[deque[t-1]][0] <= points[i][1] - points[i][0]) t--;
            deque[t++] = i;
        }

        return ans;
    }
}
