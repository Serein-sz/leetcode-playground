package L2025.L01.L643;

/**
 * @author 王强
 * @since 2025/1/16
 */
public class Main {
    public static void main(String[] args) {
        double maxAverage = new Main().findMaxAverage(new int[]{-1}, 1);
        System.out.println("maxAverage = " + maxAverage);
    }
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k - 1) {
                continue;
            }
            res = Math.max(res, sum);
            sum -= nums[i - k + 1];
        }
        return (double) res / k;
    }
}
