package find_first_and_last_position_of_element_in_sorted_array_34;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] param1 = new int[]{5,7,7,8,8,10};
        int param2 = 8;
        System.out.println(Arrays.toString(new Solution().searchRange(param1, param2)));

    }
}
