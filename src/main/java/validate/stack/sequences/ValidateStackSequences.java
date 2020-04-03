package validate.stack.sequences;

import java.util.Stack;

/**
 * @author hum
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = popped.length;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (pushed[i] != popped[j]) {
                stack.push(pushed[i]);
            } else {
                j++;
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popped[j]) {
                return false;
            }
        }
        return true;
    }
}
