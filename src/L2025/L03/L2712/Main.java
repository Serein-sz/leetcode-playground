package L2025.L03.L2712;

/**
 * @author 王强
 * @since 2025/3/27
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long result = solution.minimumCost("010101");
        System.out.println("result = " + result);
    }
}
class Solution {

    public long minimumCost(String s) {
        int n = s.length();
        long[][] suf = new long[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                suf[i][1] = suf[i + 1][1];
                suf[i][0] = suf[i + 1][1] + (n - i);
            } else {
                suf[i][1] = suf[i + 1][0] + (n - i);
                suf[i][0] = suf[i + 1][0];
            }
        }

        long[] pre = new long[2];
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                pre[0] = pre[1] + i + 1;
            } else {
                pre[1] = pre[0] + i + 1;
            }
            res = Math.min(res, Math.min(pre[0] + suf[i + 1][0], pre[1] + suf[i + 1][1]));
        }
        return res;
    }

}
