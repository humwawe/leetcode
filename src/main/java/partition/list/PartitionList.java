package partition.list;

import common.ListNode;

/**
 * @author hum
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || (head != null && head.next == null)) {
            return head;
        }
        ListNode prev = partition(head.next, x);
        if (head.val < x) {
            head.next = prev;
            return head;
        } else {
            ListNode dummy = new ListNode(-1);
            ListNode newHead = dummy;
            dummy.next = prev;
            while (prev != null && prev.val < x) {
                prev = prev.next;
                dummy = dummy.next;
            }
            dummy.next = head;
            head.next = prev;
            return newHead.next;
        }
    }
}
