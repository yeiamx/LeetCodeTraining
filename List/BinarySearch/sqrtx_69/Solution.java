package sqrtx_69;

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int left = 1; int right = x / 2;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            long curRes = (long) middle * middle;
            long nextRes = (long) (middle + 1) * (middle + 1);
            if (curRes <= x &&  nextRes > x) {
                return middle;
            } else if (middle * middle > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            System.out.println(middle);
        }
        return -1;
    }
}