package L2025.L01.L2090;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2025/1/16
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ArrayUtils.println(main.getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3));
    }

    public int[] getAverages(int[] nums, int k) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < 2 * k) {
                continue;
            }
            result[i - k] = (int) (sum / (2 * k + 1));
            sum -= nums[i - 2 * k];
        }
        return result;
    }
}
