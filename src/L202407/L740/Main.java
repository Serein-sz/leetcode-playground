package L202407.L740;

import java.util.*;

/**
 * @author 王强
 * @since 2024/7/12
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 1}));
    }

    public static int deleteAndEarn(int[] nums) {
        int[] array = new int[10001];
        for (int num : nums) {
            array[num] += num;
        }
        int first = array[0], second = array[1];
        for (int i = 2; i < array.length; i++) {
            int temp = second;
            second = Math.max(first + array[i], second);
            first = temp;
        }
        return second;
    }
}
