package L2024.L07.L68;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王强
 * @since 2024/7/18
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = {"This", "is", "an", "example", "of", "text", "justification."};
        fullJustify(strings, 16);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLen = 0;
        for (String str : words) {
            if (lineLen + str.length() > maxWidth) {
                lines.add(line);
                lineLen = 0;
                line = new ArrayList<>();
            }
            line.add(str);
            lineLen += str.length() + 1;
        }
        lines.add(line);
        System.out.println(lines);



        return null;
    }
}
