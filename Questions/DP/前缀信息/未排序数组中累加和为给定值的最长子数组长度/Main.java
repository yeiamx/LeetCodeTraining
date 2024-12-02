import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); int k = scanner.nextInt();
        // Record first index i which preSum (sum([0..i])) appears
        HashMap<Integer, Integer> preSumIndexMap = new HashMap<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        computeFirstPreSum(nums, preSumIndexMap);
        int res = nums[0] == k ? 1 : 0;
        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum += nums[i];
            if (preSumIndexMap.containsKey(preSum - k)) {
                res = Math.max(res, i - preSumIndexMap.get(preSum - k));
            }
        }
        System.out.println(res);
        scanner.close();
    }

    private static void computeFirstPreSum(int[] nums, Map<Integer, Integer> preSumIndexMap) {
        preSumIndexMap.clear();
        preSumIndexMap.put(0, -1);
        int curPreSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curPreSum += nums[i];
            if (!preSumIndexMap.containsKey(curPreSum)) {
                preSumIndexMap.put(curPreSum, i);
            }
        }
    }
}
