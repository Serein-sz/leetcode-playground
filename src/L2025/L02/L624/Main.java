package L2025.L02.L624;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author 王强
 * @since 2025/2/19
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int result = main.maxDistance(new ArrayList<>(List.of(List.of(1, 5), List.of(3, 4))));
        System.out.println("result = " + result);
    }

    public int maxDistance(List<List<Integer>> arrays) {
        arrays.sort(Comparator.comparingInt(acc -> acc.get(0)));
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int maxValue = array.get(array.size() - 1);
            if (i == 0) {
                res = Math.max(res, maxValue - arrays.get(1).get(0));
            } else {
                res = Math.max(res, maxValue - arrays.get(0).get(0));
            }
        }
        return res;
    }
}
