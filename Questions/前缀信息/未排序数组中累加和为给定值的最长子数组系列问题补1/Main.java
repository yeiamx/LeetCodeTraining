import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        // Record first index k(k < i) which preSum (sum([0..k])) appears
        HashMap<Integer, Integer> preSumIndexMap = new HashMap<>();
        preSumIndexMap.put(0, -1);

        int[] nums = new int[n]; int res = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.compare(scanner.nextInt(), 0);
        }
        for (int i = 0, preSum = 0; i < n; i++) {

            preSum += nums[i];

            if (preSumIndexMap.containsKey(preSum)) {
                res = Math.max(res, i - preSumIndexMap.get(preSum));
            }

            if (!preSumIndexMap.containsKey(preSum)) {
                preSumIndexMap.put(preSum, i);
            }
        }
        System.out.println(res);
        scanner.close();
    }
}
