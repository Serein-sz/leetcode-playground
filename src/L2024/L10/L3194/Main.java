package L2024.L10.L3194;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2024/10/18
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
    }

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.min(ans, (nums[i] + nums[nums.length - i - 1]) / 2.0f);
        }
        return ans;
    }
}
