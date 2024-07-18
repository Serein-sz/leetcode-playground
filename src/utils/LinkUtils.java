package utils;

import java.util.Objects;

/**
 * @author 王强
 * @since 2024/7/18
 */
public class LinkUtils {

    public static ListNode create(int[] nums) {
        if (nums.length == 0) {
            return new ListNode();
        }
        ListNode head = new ListNode(nums[0]);
        ListNode curNode = head;
        for (int i = 1; i < nums.length; i++) {
            curNode.next = new ListNode(nums[i]);
            curNode = curNode.next;
        }
        return head;
    }

    public static void println(ListNode head) {
        ListNode cur = head;
        StringBuilder stringBuilder = new StringBuilder("[");
        while (Objects.nonNull(cur)) {
            stringBuilder.append(cur.val + ", ");
            cur = cur.next;
        }
        String string = stringBuilder.toString();
        if (string.endsWith(", ")) {
            string = string.substring(0, string.length() - 2) + "]";
        }
        System.out.println(string);
    }
}
