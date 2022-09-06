package maximum.number.of.robots.within.budget;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class MaximumNumberOfRobotsWithinBudget {
  public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
    int n = chargeTimes.length;
    Deque<Integer> deque = new ArrayDeque<>();
    long sum = 0;
    int res = 0;
    int j = 0;
    for (int i = 0; i < n; i++) {
      while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[i]) {
        deque.removeLast();
      }
      deque.offer(i);
      sum += runningCosts[i];
      while (!deque.isEmpty() && chargeTimes[deque.peekFirst()] + (i - j + 1) * sum > budget) {
        if (deque.peekFirst() == j) {
          deque.removeFirst();
        }
        sum -= runningCosts[j++];
      }
      if (!deque.isEmpty()) {
        res = Math.max(res, i - j + 1);
      }
    }
    return res;
  }
}
