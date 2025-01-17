package L2025.L01.L3097;

/**
 * @author 王强
 * @since 2025/1/17
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int result;
        result = main.minimumSubarrayLength(new int[]{2, 32, 1, 36, 49, 78}, 106);
        System.out.println("result = " + result);
    }

    /**
     * 计算和至少为k的最小子数组长度
     *
     * @param nums 原始数组
     * @param k    目标和
     * @return 返回子数组的最小长度，如果不存在则返回-1
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        // 数组长度
        int n = nums.length;
        // 用于记录每个位上的1的数量
        int[] bits = new int[30];
        // 初始化结果为最大整数，以便后续比较
        int res = Integer.MAX_VALUE;
        // 使用双指针技术，right指针向右移动，扩展子数组
        for (int left = 0, right = 0; right < n; right++) {
            // 更新bits数组，记录当前数字每个位上的1的数量
            for (int i = 0; i < 30; i++) {
                bits[i] += (nums[right] >> i) & 1;
            }
            // 当当前子数组的和至少为k时，尝试缩小子数组以寻找更小的符合条件的子数组
            while (left <= right && calc(bits) >= k) {
                // 更新最小长度
                res = Math.min(res, right - left + 1);
                // 移动left指针，缩小子数组
                for (int i = 0; i < 30; i++) {
                    bits[i] -= (nums[left] >> i) & 1;
                }
                left++;
            }
        }
        // 如果res没有被更新，则说明没有找到符合条件的子数组，返回-1
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 计算当前bits数组代表的数字和
     *
     * @param bits bits数组
     * @return 当前bits数组代表的数字和
     */
    private int calc(int[] bits) {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            if (bits[i] > 0) {
                sum += (1 << i);
            }
        }
        return sum;
    }

}
