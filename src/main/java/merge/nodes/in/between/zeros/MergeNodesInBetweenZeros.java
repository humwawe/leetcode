package merge.nodes.in.between.zeros;

import common.ListNode;

/**
 * @author hum
 */
public class MergeNodesInBetweenZeros {
  public ListNode mergeNodes(ListNode head) {
    head = head.next;
    ListNode res = new ListNode(0);
    ListNode node = res;
    int sum = 0;
    while (head != null) {
      if (head.val == 0) {
        node.next = new ListNode(sum);
        node = node.next;
        sum = 0;
      } else {
        sum += head.val;
      }
      head = head.next;
    }
    return res.next;
  }
}
