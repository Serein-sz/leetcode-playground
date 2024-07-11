package L202407.L1997;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2024/7/11
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(firstDayBeenInAllRooms(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public static int firstDayBeenInAllRooms(int[] nextVisit) {
        int mod = 1000000007;
        int len = nextVisit.length;
        int[] dp = new int[len];
        //初始化原地待一天 + 访问下一个房间一天
        dp[0] = 2;
        for (int i = 1; i < len; i++) {
            int to = nextVisit[i];
            dp[i] = 2 + dp[i - 1];
            if (to != 0) {
                //避免负数
                dp[i] = (dp[i] - dp[to - 1] + mod) % mod;
            }

            dp[i] = (dp[i] + dp[i - 1]) % mod;
        }
        return dp[len - 2];
    }
}
