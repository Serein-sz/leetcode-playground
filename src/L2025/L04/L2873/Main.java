package L2025.L04.L2873;

/**
 * @author 王强
 * @since 2025/4/2
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.maximumTripletValue(new int[]{12, 6, 1, 2, 7});
        System.out.println("result = " + result);
    }
}

class Solution {

    public long maximumTripletValue(int[] nums) {
        long result = Long.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    result = Math.max(result, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return result < 0 ? 0 : result;
    }

}
