package L2025.L02.L2080;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王强
 * @since 2025/2/18
 */
public class Main {
    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        int result = rangeFreqQuery.query(1, 2, 4);
        System.out.println("result = " + result);
        result = rangeFreqQuery.query(0, 11, 33);
        System.out.println("result = " + result);
    }
}

class RangeFreqQuery {

    Map<Integer, List<Integer>> mapper = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            List<Integer> positions = mapper.getOrDefault(arr[i], new ArrayList<>());
            positions.add(i);
            mapper.put(arr[i], positions);
        }
    }

    public int query(int left, int right, int value) {
        int res = 0;
        List<Integer> positions = mapper.get(value);
        if (positions == null) {
            return res;
        }
        return findRightBoundary(positions, right) - findLeftBoundary(positions, left);
    }

    private int findLeftBoundary(List<Integer> positions, int target) {
        int left = 0, right = positions.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (positions.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int findRightBoundary(List<Integer> positions, int target) {
        int left = 0, right = positions.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (positions.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
