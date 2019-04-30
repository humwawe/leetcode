package swap.nodes.in.pairs;

import common.ListNode;

/**
 * @author hum
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        cur.next = head;
        ListNode first = head;
        ListNode second;
        while (first != null && (second = first.next) != null) {
            cur.next = second;
            first.next = second.next;
            second.next = first;
            cur = first;
            first = cur.next;
        }
        return newHead.next;
    }
}
