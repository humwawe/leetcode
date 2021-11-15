package reverse.nodes.in.even.length.groups;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class ReverseNodesInEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int len = list.size();
        List<Integer> res = new ArrayList<>();
        int last = 0;
        int sum = 0;
        while (sum < len) {
            int size = Math.min(last + 1, len - sum);
            if (size % 2 == 0) {
                for (int i = sum + size - 1; i >= sum; i--) {
                    res.add(list.get(i));
                }
            } else {
                for (int i = sum; i < sum + size; i++) {
                    res.add(list.get(i));
                }
            }
            sum += size;
            last = size;
        }
        tmp = head;
        int idx = 0;
        while (tmp != null) {
            tmp.val = res.get(idx++);
            tmp = tmp.next;
        }
        return head;
    }
}
