package L202410.L3158;

/**
 * @author 王强
 * @since 2024/10/12
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().duplicateNumbersXOR(new int[]{1, 2, 1, 3}));
    }

    public int duplicateNumbersXOR(int[] nums) {
        long bitSet = 0L;
        int res = 0;
        for (int n : nums) {
            long numberBit = 1L << n;
            if ((bitSet & numberBit) == numberBit) {
                res ^= n;
            } else {
                bitSet = numberBit;
            }
        }
        return res;
    }
}