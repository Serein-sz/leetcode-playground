package L2025.L02.L935;

import utils.TimeTracker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王强
 * @since 2025/2/17
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        // 20
        System.out.println("main.knightDialer(2) = " + main.knightDialer(2));
        // 46
        System.out.println("main.knightDialer(3) = " + main.knightDialer(3));
        // 104
        System.out.println("main.knightDialer(4) = " + main.knightDialer(4));
        // 136006598
        TimeTracker.track("3131", () -> {
            System.out.println("main.knightDialer(3131) = " + main.knightDialer(3131));
        });
    }

    static final int MOD = 1000000007;

    public int knightDialer(int n) {
        int[][] mapper = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        if (n == 1) {
            return 10;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, 1);
        }
        for (int i = 2; i <= n; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                int count = 0;
                for (int k : mapper[j]) {
                    count = (count + map.getOrDefault(k, 0)) % MOD;
                }
                temp.put(j, count);
            }
            map = temp;
        }
        int res = 0;
        for (Integer value : map.values()) {
            res = (res + value) % MOD;
        }
        return res;
    }
}
