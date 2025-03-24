package L2025.L03.L2255;

/**
 * @author 王强
 * @since 2025/3/24
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.countPrefixes(new String[]{"a", "b", "c", "ab", "bc", "abc"}, "abc");
        System.out.println("result = " + result);
    }
}
class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                res++;
            }
        }
        return res;
    }
}
