import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] H = new int[n]; int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                H[i] = in.nextInt();
                min = Math.min(min, H[i]);
                max = Math.max(max, H[i]);
            }
            System.out.println(minE(H, min, max));
        }
    }

    private static int minE(int[] H, int min, int max) {
        int ans = 0;
        int left = min; int right = max;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (fn(H, mid, max)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // IF Given E Can pass H list.
    private static boolean fn(int[] H, long E, int maxInH) {
        long curE = E;
        for (int h : H) {
            // Have to cut curE, or it‘ll over long
            if (curE >= maxInH) {
                return true;
            }
            if (curE >= h) {
                curE += (curE - h);
            } else {
                curE -= (h - curE);
            }
            if (curE < 0) return false;
        }
        return true;
    }
}
