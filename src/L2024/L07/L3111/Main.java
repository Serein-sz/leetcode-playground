package L2024.L07.L3111;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 王强
 * @since 2024/7/31
 */
public class Main {
    public static void main(String[] args) {
//        int[][] points = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}};
        int[][] points = new int[][]{{1, 3}, {1, 7}};
        System.out.println(minRectanglesToCoverPoints(points, 2));
    }

    public static int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans = 0, bound = -1;
        for (int[] point : points) {
            if (point[0] > bound) {
                bound = point[0] + w;
                ans++;
            }
        }
        return ans;
    }
}
