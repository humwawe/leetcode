package number.of.visible.people.in.a.queue;

import java.util.Stack;

/**
 * @author hum
 */
public class NumberOfVisiblePeopleInAQueue {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                ans[i]++;
                stack.pop();
            }
            stack.push(i);
            if (stack.size() > 1) {
                ans[i]++;
            }
        }
        return ans;
    }
}
