package L2025.L02.L656;

import utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王强
 * @since 2025/2/24
 */
public class Main {
    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(5);
        System.out.println("orderedStream.insert(3, \"ccccc\") = " + orderedStream.insert(3, "ccccc"));
        System.out.println("orderedStream.insert(1, \"aaaaa\") = " + orderedStream.insert(1, "aaaaa"));
        System.out.println("orderedStream.insert(2, \"bbbbb\") = " + orderedStream.insert(2, "bbbbb"));
        System.out.println("orderedStream.insert(5, \"eeeee\") = " + orderedStream.insert(5, "eeeee"));
        System.out.println("orderedStream.insert(4, \"ddddd\") = " + orderedStream.insert(4, "ddddd"));
    }
}

class OrderedStream {

    private final String[] stream;

    private int ptr = 1;

    public OrderedStream(int n) {
        this.stream = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> res = new ArrayList<>();
        while (ptr - 1 < stream.length && stream[ptr - 1] != null) {
            res.add(stream[ptr - 1]);
            ++ptr;
        }
        return res;
    }
}

