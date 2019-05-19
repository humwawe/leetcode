package remove.duplicates.from.sorted.list.II;

import common.ListNode;

/**
 * @author hum
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        ListNode first = head, second;

        while (first != null && (second = first.next) != null) {
            if (first.val != second.val) {
                cur.next = first;
                cur = cur.next;
                first = first.next;
            } else {
                while (second.next != null && second.next.val == first.val) {
                    second = second.next;
                }
                first = second.next;
            }
        }
        if (first != null) {
            cur.next = first;
        } else {
            cur.next = null;
        }

        return dummyHead.next;
    }
}

