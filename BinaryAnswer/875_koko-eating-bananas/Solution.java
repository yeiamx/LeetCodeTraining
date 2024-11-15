class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int l = 1; int r = max; int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (getTime(piles, mid) <= h) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private long getTime(int[] piles, int speed) {
        long res = 0;
        for (int i = 0; i < piles.length; i++) {
            // a/b向上取整
            res += (piles[i] + speed - 1) / speed;
        }
        return res;
    }
}
