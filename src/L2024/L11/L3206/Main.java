package L2024.L11.L3206;

import java.util.Arrays;

/**
 * @author 王强
 * @since 2024/11/26
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1}));
    }

    public int numberOfAlternatingGroups(int[] colors) {
        int[] ints = Arrays.copyOf(colors, colors.length + 2);
        ints[ints.length - 2] = ints[0];
        ints[ints.length - 1] = ints[1];
        int res = 0;
        for (int i = 0; i < colors.length; i++) {
            if (ints[i] == ints[i + 2] && ints[i] != ints[i + 1]) {
                res++;
            }
        }
        return res;
    }

}
