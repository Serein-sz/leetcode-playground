package L2025.L01.L674;

/**
 * @author 王强
 * @since 2025/1/16
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().findLengthOfLCIS(new int[]{1, 3, 5, 7}));
        System.out.println(new Main().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new Main().findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int l = 0, r = 1, res = 0;
        while (r < nums.length) {
            if (nums[r] <= nums[r - 1]) {
                res = Math.max(res, r - l);
                l = r;
            }
            r++;
        }
        return Math.max(res, r - l);
    }

}
