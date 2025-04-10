package L2025.L04.L2140;

/**
 * @author 王强
 * @since 2025/4/1
 */
public class Main {
    public static void main(String[] args) {
        long result = mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}});
        System.out.println("result(5) = " + result);
    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(n, i + questions[i][1] + 1)]);
        }
        return dp[0];
    }

}
