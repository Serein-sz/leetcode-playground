package L202407.L2834;

/**
 * @author 王强
 * @since 2024/7/12
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(minimumPossibleSum(39636, 49035));
    }
    public static int minimumPossibleSum(int n, int target) {
        final int mod = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % mod);
        }
        return (int) (((long) (1 + m) * m / 2 +
                ((long) target + target + (n - m) - 1) * (n - m) / 2) % mod);
    }
}
