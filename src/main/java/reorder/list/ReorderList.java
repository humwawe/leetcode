package reorder.list;

import common.ListNode;

/**
 * @author hum
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode first = head;
        ListNode second = head;
        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }

        ListNode head2 = second.next;
        second.next = null;
        head2 = helper(head2);

        ListNode cur = head;
        ListNode head1 = head.next;
        while (head1 != null) {
            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
            cur.next = head1;
            head1 = head1.next;
            cur = cur.next;
        }
        if (head2 != null) {
            cur.next = head2;
        }
    }

    private ListNode helper(ListNode head2) {
        ListNode prev = null, cur = head2;
        while (cur != null) {
            ListNode tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
        }
        return prev;

    }
}
