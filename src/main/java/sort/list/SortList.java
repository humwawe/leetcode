package sort.list;

import common.ListNode;

/**
 * @author hum
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);

    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        ListNode cur1 = left;
        ListNode cur2 = right;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                head.next = cur1;
                cur1 = cur1.next;
            } else {
                head.next = cur2;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        if (cur1 != null) {
            head.next = cur1;
        }
        if (cur2 != null) {
            head.next = cur2;
        }
        return dummy.next;

    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
