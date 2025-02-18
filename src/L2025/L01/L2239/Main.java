package L2025.L01.L2239;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2025/1/20
 */
public class Main {

    public static void main(String[] args) {
        // int result = new Main().findClosestNumber(new int[]{-4, -2, 1, 4, 8});
        int result = new Main().findClosestNumber(new int[]{2, -1, 1});
        System.out.println("result = " + result);
    }

    public int findClosestNumber(int[] nums) {
        int res = Integer.MIN_VALUE, distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int num : nums) {
            if (Math.abs(num) <= distance) {
                distance = Math.abs(num);
                res = num;
            }
        }
        return res;
    }
}
