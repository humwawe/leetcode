package merge.in.between.linked.lists;

import common.ListNode;

/**
 * @author hum
 */
public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode res = new ListNode(-1);
        res.next = list1;
        int i = 0;
        ListNode t1 = res;
        while (i < a) {
            t1 = t1.next;
            i++;
        }
        ListNode t2 = list1;
        i = 0;
        while (i < b) {
            t2 = t2.next;
            i++;
        }
        t1.next = list2;
        ListNode t3 = list2;
        while (t3.next != null) {
            t3 = t3.next;
        }
        t3.next = t2.next;
        return res.next;
    }
}
