class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int last1 = 0; int last2 = 1;
        int curIndex = 2;
        while (curIndex < n) {
            int temp = last2;
            last2 = last1 + last2;
            last1 = temp;
            curIndex++;
        }
        return last1 + last2;
    }
}
