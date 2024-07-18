package L202407.LCR042;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王强
 * @since 2024/7/18
 */
public class Main {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

}

class RecentCounter {
    List<Integer> counter;
    public RecentCounter() {
        counter = new ArrayList<>();
    }

    public int ping(int t) {
        counter.add(t);
        int ans = 0;
        for (int i = counter.size() - 1; i >= 0; i--) {
            if (counter.get(i) > t - 3000) {
                ans++;
            }
        }
        return ans;
    }
}