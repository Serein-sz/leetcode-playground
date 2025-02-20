package L2025.L02.L2595;

import utils.ArrayUtils;

/**
 * @author 王强
 * @since 2025/2/20
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ArrayUtils.println(main.evenOddBit(17));
    }
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int i = 0;
        while (n > 0) {
            res[i] += n & 1;
            n >>= 1;
            i ^= 1;
        }
        return res;
    }
}
