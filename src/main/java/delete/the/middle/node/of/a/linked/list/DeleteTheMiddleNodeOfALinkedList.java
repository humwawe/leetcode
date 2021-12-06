package delete.the.middle.node.of.a.linked.list;

import common.ListNode;

/**
 * @author hum
 */
public class DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummp = new ListNode(0);
        dummp.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummp;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = slow.next;
        return dummp.next;
    }
}
