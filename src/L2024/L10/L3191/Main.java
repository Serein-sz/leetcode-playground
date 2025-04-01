package L2024.L10.L3191;

/**
 * @author 王强
 * @since 2024/10/18
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(new Main().minOperations(new int[]{0, 1, 1, 1}));
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i > nums.length - 3) {
                    return -1;
                }
                ans += 1;
                nums[i] = 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
            }
        }
        return ans;
    }
}
