package next.greater.node.in.linked.list;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author hum
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        while (head != null) {
            while (!stack.isEmpty() && head.val > stack.peek()[1]) {
                int[] pop = stack.pop();
                map.put(pop[0], head.val);
            }
            stack.add(new int[]{idx, head.val});
            idx++;
            head = head.next;
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop()[0], 0);
        }
        int[] result = new int[map.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(i);
        }
        return result;
    }
}
