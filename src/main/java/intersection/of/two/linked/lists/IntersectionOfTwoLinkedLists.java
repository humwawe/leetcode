package intersection.of.two.linked.lists;

import common.ListNode;

/**
 * @author hum
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while (tmp1 != null && tmp2 != null) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (tmp1 != null) {
            tmp1 = tmp1.next;
            cur1 = cur1.next;
        }
        while (tmp2 != null) {
            tmp2 = tmp2.next;
            cur2 = cur2.next;
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
