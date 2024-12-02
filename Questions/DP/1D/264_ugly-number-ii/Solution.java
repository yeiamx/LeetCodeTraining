class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1; uglyNumbers[1] = 2;
        int p2 = 1; int p3 = 0; int p5 = 0;

        for (int i = 2; i < n; i++) {
            uglyNumbers[i] = Math.min(uglyNumbers[p2] * 2, Math.min(uglyNumbers[p3] * 3, uglyNumbers[p5] * 5));
            boolean p2Min = false; boolean p3Min = false; boolean p5Min = false;
            if (uglyNumbers[p2] * 2 <= uglyNumbers[p3] * 3 && uglyNumbers[p2] * 2 <= uglyNumbers[p5] * 5) {
               p2Min = true;
            }
            if (uglyNumbers[p3] * 3 <= uglyNumbers[p2] * 2 && uglyNumbers[p3] * 3 <= uglyNumbers[p5] * 5) {
                p3Min = true;
            }
            if (uglyNumbers[p5] * 5 <= uglyNumbers[p3] * 3 && uglyNumbers[p5] * 5 <= uglyNumbers[p2] * 2) {
                p5Min = true;
            }
            if (p2Min) p2++; if (p3Min) p3++; if (p5Min) p5++;
        }

        return uglyNumbers[n - 1];
    }
}
