package L2024.L07.L198;

/**
 * @author 王强
 * @since 2024/7/12
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += nums[i];
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
