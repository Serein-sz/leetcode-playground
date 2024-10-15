package L202410.L3163;

import utils.BenchmarkUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王强
 * @since 2024/10/11
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        BenchmarkUtils.execute(10, () -> {
            System.out.println(new Main().numberOfPairs(new int[]{1, 3, 4}, new int[]{1, 3, 4}, 1));
        });
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> count1 = new HashMap<>();
        Map<Integer, Integer> count2 = new HashMap<>();
        int max = -1;
        for (int num1 : nums1) {
            count1.put(num1, count1.getOrDefault(num1, 0) + 1);
            max = Math.max(max, num1);
        }
        for (int num2 : nums2) {
            count2.put(num2, count2.getOrDefault(num2, 0) + 1);
        }
        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : count2.entrySet()) {
            int num2 = entry.getKey();
            for (int i = num2 * k; i <= max; i += num2 * k) {
                if (count1.containsKey(i)) {
                    ans += (long) count1.get(i) * entry.getValue();
                }
            }
        }
        return ans;
    }

}

