import java.util.HashSet;
import java.util.LinkedHashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Long> sumSet = new LinkedHashSet<>();
        Long squareSum = (long) n;
        while (squareSum != 1) {
            squareSum = getSquareSum(squareSum);
            if (sumSet.contains(squareSum)) {
                return false;
            } else {
                sumSet.add(squareSum);
            }
        }
        return true;
    }
    private Long getSquareSum(Long n) {
        long res = 0L;
        while (n > 0) {
            long num = n % 10;
            res += num * num;
            n /= 10;
        }
        return res;
    }
}
