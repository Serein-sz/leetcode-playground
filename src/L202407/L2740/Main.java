package L202407.L2740;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2024/7/26
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(findValueOfPartition(new int[]{1, 3, 2, 4}));
    }

    public static int findValueOfPartition(int[] nums) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.min(ans, nums[i + 1] - nums[i]);
        }
        return ans;
    }
}
