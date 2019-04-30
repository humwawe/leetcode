package remove.nth.node.from.end.of.list;

import common.ListNode;

/**
 * @author hum
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (n-- > 0) {
            cur = cur.next;
        }
        if (cur == null) {
            head = head.next;
            return head;
        }
        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return head;
    }

}

