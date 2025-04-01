package L2024.L08.LCP40;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2024/8/1
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(maxmiumScore(new int[]{1, 2, 8, 9}, 3));
    }
    public static int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int ans = 0;
        for (int i = cards.length - 1; i > 0; i--) {
            int card = cards[i];
            if (card % 2 == 0) {
                ans += card;
                cnt--;
            }
        }
        return cnt > 0 ? 0 : ans;
    }
}
