package find.the.minimum.and.maximum.number.of.nodes.between.critical.points;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                tmp.add(i);
            }
            if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                tmp.add(i);
            }
        }
        if (tmp.size() < 2) {
            return new int[]{-1, -1};
        }
        int x = (int) 1e8;
        for (int i = 1; i < tmp.size(); i++) {
            x = Math.min(x, tmp.get(i) - tmp.get(i - 1));
        }
        int y = tmp.get(tmp.size() - 1) - tmp.get(0);
        return new int[]{x, y};
    }
}
