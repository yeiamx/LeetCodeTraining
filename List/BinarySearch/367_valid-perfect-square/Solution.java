package sqrtx_69;

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int left = 1; int right = num / 2;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            long curRes = (long) middle * middle;
            if (curRes == num) {
                return true;
            }
            if (curRes > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }
        return false;
    }
}
