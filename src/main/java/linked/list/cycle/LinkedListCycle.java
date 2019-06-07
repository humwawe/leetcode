package linked.list.cycle;

import common.ListNode;

/**
 * @author hum
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head;

        while (true) {
            if (first.next == null || first.next.next == null) {
                return false;
            }
            first = first.next.next;
            second = second.next;
            if (first == second) {
                return true;
            }
        }
    }
}
