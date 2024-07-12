package utils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author 王强
 * @since 2024/7/12
 */
public class ArrayUtils {

    private ArrayUtils() {}

    public static void println(int[] array) {
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }

}
