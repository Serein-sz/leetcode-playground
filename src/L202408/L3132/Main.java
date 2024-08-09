package L202408.L3132;

import utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2024/8/9
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {4, 6, 3, 1, 4, 2, 10, 9, 5};
        int[] nums2 = {5, 10, 3, 2, 6, 1, 9};
        System.out.println(minimumAddedInteger(nums1, nums2));
    }

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        ArrayUtils.println(nums1);
        Arrays.sort(nums2);
        ArrayUtils.println(nums2);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length - nums2.length + 1; i++) {
            ans = Math.min(nums2[0] - nums1[i], ans);
        }
        return ans;
    }
}
