import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //new Solution().maxSubArraySumDividedBySeven(new int[]{3, 7, 22});
        correcter();
    }

    public static void correcter() {
        Solution solution = new Solution();
        int n = 15;
        int v = 30;
        int testTime = 20000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int len = (int) (Math.random() * n) + 1;
            int[] nums = randomArray(len, v);
            int ans1 = solution.maxSubArraySumDividedBySeven(nums);
            int ans2 = solution.correcter(nums);
            if (ans1 != ans2) {
                System.out.println("出错了!");
                System.out.println(Arrays.toString(nums));
                System.out.println("Compute:" + ans1);
                System.out.println("Expected:" + ans2);
                break;
            }
        }
        System.out.println("测试结束");
    }

    // 为了测试
    // 生成随机数组
    public static int[] randomArray(int n, int v) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * v);
        }
        return ans;
    }
}
