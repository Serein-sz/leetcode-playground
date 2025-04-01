package L2024.L10.L3162;

import utils.BenchmarkUtils;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2024/10/10
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BenchmarkUtils.execute(20, () -> new Main().numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        // System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        return (int) Arrays.stream(nums1).mapToLong(num1 -> Arrays.stream(nums2).filter(num2 -> num1 % (num2 * k) == 0).count()).sum();
    }
}
