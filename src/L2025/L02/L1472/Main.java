package L2025.L02.L1472;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 王强
 * @since 2025/2/26
 */
public class Main {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("google.com");
        // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("facebook.com");
        // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        browserHistory.visit("youtube.com");
        // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        String result = browserHistory.back(1);
        System.out.println(result);
        // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        result = browserHistory.back(1);
        System.out.println(result);
        // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        result = browserHistory.forward(1);
        System.out.println(result);
        // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        browserHistory.visit("linkedin.com");
        // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        result = browserHistory.forward(2);
        System.out.println(result);
        // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        result = browserHistory.back(2);
        System.out.println(result);
        // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
        result = browserHistory.back(7);
        System.out.println(result);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
class BrowserHistory {

    private final List<String> history = new ArrayList<>();

    private int current = 0;

    public BrowserHistory(String homepage) {
        history.add(homepage);
    }

    public void visit(String url) {
        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        current++;
    }

    public String back(int steps) {
        current = Math.max(current - steps, 0);
        return history.get(current);
    }

    public String forward(int steps) {
        current = Math.min(current + steps, history.size() - 1);
        return history.get(current);
    }

}

