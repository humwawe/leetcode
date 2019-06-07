package linked.list.cycle.II;

import common.ListNode;

/**
 * @author hum
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        do {
            if (first.next == null || first.next.next == null) {
                return null;
            }
            first = first.next.next;
            second = second.next;
        } while (first != second);
        ListNode result = head;
        while (result != second) {
            result = result.next;
            second = second.next;
        }
        return result;
    }
}
