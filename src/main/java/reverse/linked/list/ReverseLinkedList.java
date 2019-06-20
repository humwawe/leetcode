package reverse.linked.list;

import common.ListNode;

/**
 * @author hum
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        System.out.println(head.val);
        ListNode next = reverseList(head.next);
        if (next == null) {
            return head;
        }
        ListNode tmp = next;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = head;
        head.next = null;
        return next;
    }
}
