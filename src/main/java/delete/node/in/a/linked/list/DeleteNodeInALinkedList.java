package delete.node.in.a.linked.list;

import common.ListNode;

/**
 * @author hum
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
