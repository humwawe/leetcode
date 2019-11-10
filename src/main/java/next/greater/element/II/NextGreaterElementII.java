package next.greater.element.II;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hum
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * len; i++) {
            int index = i % len;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                result[stack.peek()] = nums[index];
                stack.pop();
            }
            if (i < len) {
                stack.push(i);
            }
        }
        return result;
    }

}
