package maximize.distance.to.closest.person;

import java.util.Stack;

/**
 * @author hum
 */
public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int count = 0;
        for (int seat : seats) {
            if (seat == 1) {
                if (stack.isEmpty()) {
                    result = Math.max(result, count);
                } else if (stack.peek() == 1) {
                    result = Math.max(result, (count - 1) / 2 + 1);
                    stack.pop();
                }
                count = 0;
                stack.push(1);
            } else {
                count++;
            }
        }
        return Math.max(result, count);
    }
}
