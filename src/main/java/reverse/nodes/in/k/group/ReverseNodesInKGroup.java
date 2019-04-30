package reverse.nodes.in.k.group;

import common.ListNode;

/**
 * @author hum
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode check = head;
        ListNode cur = head;
        ListNode prev = null;
        ListNode tmp = null;
        int count = 0;
        while (check != null && count < k) {
            check = check.next;
            count++;
        }
        if (count == k) {
            count = 0;
            while (count < k) {
                tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
                count++;
            }
            if (tmp != null) {
                head.next = reverseKGroup(tmp, k);
            }
            return prev;

        }
        return head;
    }


}
