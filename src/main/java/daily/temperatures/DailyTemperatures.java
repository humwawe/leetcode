package daily.temperatures;

import java.util.Stack;

/**
 * @author hum
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        int len = t.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[stack.peek()] < t[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
