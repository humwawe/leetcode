package reverse.linked.list.II;

import common.ListNode;

/**
 * @author hum
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode tail = cur;
        ListNode tmp = cur.next;
        for (int i = m; i < n; i++) {
            ListNode last = tmp.next;
            tmp.next = cur;
            cur = tmp;
            tmp = last;
        }
        pre.next = cur;
        tail.next = tmp;
        return dummy.next;
    }
}
