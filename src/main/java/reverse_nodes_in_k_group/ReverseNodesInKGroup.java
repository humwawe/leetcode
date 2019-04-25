package reverse_nodes_in_k_group;

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
        boolean reverseFlag = false;
        while (check != null && count++ < k) {
            check = check.next;
            reverseFlag = true;
        }
        if (reverseFlag) {
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
            } else {
                return prev;
            }
        }
        return head;

    }


}
