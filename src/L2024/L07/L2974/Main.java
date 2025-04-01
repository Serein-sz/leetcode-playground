package L2024.L07.L2974;

import java.util.Arrays;

import static utils.ArrayUtils.println;

/**
 * @author 王强
 * @since 2024/7/12
 */
public class Main {

    public static void main(String[] args) {
        println(numberGame(new int[]{5, 4, 2, 3}));
    }

    public static int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] ans = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i += 2) {
            if (i + 1 >= ans.length) {
                return ans;
            }
            int temp = ans[i];
            ans[i] = ans[i + 1];
            ans[i + 1] = temp;
        }
        return ans;
    }
}
