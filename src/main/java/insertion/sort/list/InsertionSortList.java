package insertion.sort.list;

import common.ListNode;

/**
 * @author hum
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tmp = insertionSortList(head.next);
        ListNode pre = null, dummy = new ListNode(0);
        dummy.next = tmp;
        while (tmp != null && head.val > tmp.val) {
            pre = tmp;
            tmp = tmp.next;
        }
        if (pre == null) {
            head.next = tmp;
            return head;

        }
        pre.next = head;
        head.next = tmp;
        return dummy.next;
    }
}
