package swapping.nodes.in.a.linked.list;

import common.ListNode;

/**
 * @author hum
 */
public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        ListNode cur = first;
        ListNode second = head;
        while (cur.next != null) {
            cur = cur.next;
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return dummy.next;
    }
}
