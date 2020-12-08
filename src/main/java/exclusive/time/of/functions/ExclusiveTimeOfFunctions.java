package exclusive.time.of.functions;

import java.util.List;
import java.util.Stack;

/**
 * @author hum
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int tmp = Integer.valueOf(split[2]);
            int index = Integer.valueOf(split[0]);
            if ("start".equals(split[1])) {
                stack.push(tmp);
            } else {
                int prev = 0;
                while (stack.peek() < 0) {
                    prev += stack.pop() - 1;
                }
                result[index] += tmp - stack.peek() + prev + 1;
                stack.add(stack.pop() - tmp - 1);
            }
        }
        return result;
    }
}
