package L2025.L02.L922;

import utils.ArrayUtils;

/**
 * @author 王强
 * @since 2025/2/17
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ArrayUtils.println(main.sortArrayByParityII(new int[]{4, 2, 5, 7}));
        ArrayUtils.println(main.sortArrayByParityII(new int[]{3, 1, 4, 2}));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length, j = 1;
        for (int i = 0; i < n; i += 2) {
            if ((nums[i] & 1) == 1) {
                while ((nums[j] & 1) == 1) {
                    j++;
                }
                nums[j] += nums[i];
                nums[i] = nums[j] - nums[i];
                nums[j] = nums[j] - nums[i];
            }
        }
        return nums;
    }
}
