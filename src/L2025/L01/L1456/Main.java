package L2025.L01.L1456;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王强
 * @since 2025/1/16
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("new Main().maxVowels(\"abciiidef\", 3) = " + new Main().maxVowels("abciiidef", 3));
    }

    public int maxVowels(String s, int k) {
        int res = -1;
        char[] charArray = s.toCharArray();
        Container container = new Container(k);
        for (char c : charArray) {
            container.add(c);
            res = Math.max(res, container.getCount());
        }
        return res;
    }

}

class Container {

    private final List<Character> characters = new ArrayList<>(3);

    private int count = 0;

    private final int k;

    private final List<Character> chars = List.of('a', 'e', 'i', 'o', 'u' );

    public Container(int k) {
        this.k = k;
    }

    public void add(Character character) {
        if (characters.size() == k) {
            if (chars.contains(characters.get(0))) {
                count--;
            }
            characters.remove(0);
        }
        if (chars.contains(character)) {
            count++;
        }
        characters.add(character);
    }

    public int getCount() {
        return count;
    }
}
