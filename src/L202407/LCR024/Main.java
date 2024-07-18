package L202407.LCR024;

import utils.LinkUtils;
import utils.ListNode;

/**
 * @author 王强
 * @since 2024/7/18
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = LinkUtils.create(new int[]{1, 2, 3, 4, 5});
        LinkUtils.println(head);
        LinkUtils.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }

}
