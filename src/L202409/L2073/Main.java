package L202409.L2073;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @author 王强
 * @since 2024/9/29
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        System.out.println(main.timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(main.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int[] res = new int[tickets.length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.add(new int[]{i, tickets[i]});
        }
        int second = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[1] != 0) {
                second++;
                poll[1]--;
                res[poll[0]] = second;
                queue.add(poll);
            }
        }
        return res[k];
    }
}
