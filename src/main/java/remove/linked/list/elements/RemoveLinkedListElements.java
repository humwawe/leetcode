package remove.linked.list.elements;

import common.ListNode;

/**
 * @author hum
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode tmp = removeElements(head.next, val);
        if (head.val == val) {
            return tmp;
        } else {
            head.next = tmp;
            return head;
        }
    }
}
