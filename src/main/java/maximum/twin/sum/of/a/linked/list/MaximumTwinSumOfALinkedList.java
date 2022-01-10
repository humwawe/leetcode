package maximum.twin.sum.of.a.linked.list;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res = Math.max(res, list.get(i) + list.get(list.size() - i - 1));
        }
        return res;
    }
}
