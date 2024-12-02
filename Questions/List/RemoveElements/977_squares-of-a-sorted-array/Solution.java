class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int head = 0; int tail = nums.length - 1; int index = nums.length - 1;
        while (head <= tail) {
            if (nums[head] * nums[head] > nums[tail] * nums[tail]) {
                res[index--] = nums[head] * nums[head];
                head++;
            } else {
                res[index--] = nums[tail] * nums[tail];
                tail--;
            }
        }
        return res;
    }
}
