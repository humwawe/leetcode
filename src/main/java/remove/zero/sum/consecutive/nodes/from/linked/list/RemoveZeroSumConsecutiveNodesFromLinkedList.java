package remove.zero.sum.consecutive.nodes.from.linked.list;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            map.put(sum, node);
        }
        sum = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            sum += node.val;
            node.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
