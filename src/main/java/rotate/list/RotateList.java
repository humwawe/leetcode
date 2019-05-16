package rotate.list;

import common.ListNode;

/**
 * @author hum
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        ListNode first = head, second = head;
        while (k-- > 0) {
            first = first.next;
        }

        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        ListNode newHead = second.next;
        first.next = head;
        second.next = null;
        return newHead;

    }
}
