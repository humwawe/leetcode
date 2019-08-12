package odd.even.linked.list;

import common.ListNode;

/**
 * @author hum
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        ListNode tmp = second;

        while (second != null && second.next != null) {
            first.next = second.next;
            first = first.next;
            second.next = first.next;
            second = second.next;
        }
        first.next = tmp;
        return head;
    }
}
