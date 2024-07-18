package L202407.L2956;

import utils.ArrayUtils;

/**
 * @author 王强
 * @since 2024/7/16
 */
public class Main {
    public static void main(String[] args) {
        ArrayUtils.println(findIntersectionValues(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6}));
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] mark1 = new boolean[101];
        boolean[] mark2 = new boolean[101];
        int[] ans = {0, 0};
        for (int num : nums1) {
            mark1[num] = true;
        }
        for (int num : nums2) {
            mark2[num] = true;
            if (mark1[num]) {
                ans[0]++;
            }
        }
        for (int num : nums1) {
            if (mark2[num]) {
                ans[1]++;
            }
        }
        return ans;
    }
}
