package linked.list.components;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class LinkedListComponents {
    public int numComponents(ListNode head, int[] g) {
        Set<Integer> set = new HashSet<>();
        for (int i : g) {
            set.add(i);
        }
        ListNode tmp = head;
        int result = 0;
        boolean flag = false;
        while (tmp != null) {
            if (set.contains(tmp.val)) {
                if (!flag) {
                    result += 1;
                    flag = true;
                }
            } else {
                if (flag) {
                    flag = false;
                }
            }
            tmp = tmp.next;
        }
        return result;
    }
}
