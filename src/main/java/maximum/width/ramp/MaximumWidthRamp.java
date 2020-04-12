package maximum.width.ramp;

import java.util.Stack;

/**
 * @author hum
 */
public class MaximumWidthRamp {
    public int maxWidthRamp(int[] a) {
        int len = a.length;
        Stack<Integer> stacks = new Stack<>();
        stacks.push(0);
        for (int i = 1; i < len; i++) {
            if (a[i] <= a[stacks.peek()]) {
                stacks.push(i);
            }
        }
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            while (!stacks.isEmpty() && a[i] >= a[stacks.peek()]) {
                result = Math.max(result, i - stacks.pop());
            }
        }
        return result;
    }
}
