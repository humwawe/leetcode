package max.value.of.equation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class MaxValueOfEquation {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = points.length;
        int result = -(int) 1e9;
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && points[i][0] - points[deque.getFirst()][0] > k) {
                deque.pollFirst();
            }
            if (!deque.isEmpty()) {
                result = Math.max(result, points[i][1] + points[deque.getFirst()][1] + points[i][0] - points[deque.getFirst()][0]);
            }
            while (!deque.isEmpty() && points[i][1] - points[i][0] >= points[deque.getLast()][1] - points[deque.getLast()][0]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return result;
    }
}
