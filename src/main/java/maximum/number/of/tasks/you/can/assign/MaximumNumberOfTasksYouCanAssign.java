package maximum.number.of.tasks.you.can.assign;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author hum
 */
public class MaximumNumberOfTasksYouCanAssign {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length;
        int m = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int l = 0;
        int r = tasks.length;

        while (l < r) {
            Deque<Integer> deque = new ArrayDeque<>();
            int pp = pills;
            int mid = l + r + 1 >> 1;
            int j = m - 1;
            boolean f = true;

            for (int i = mid - 1; i >= 0; i--) {
                while (j >= m - mid && j >= 0 && workers[j] + strength >= tasks[i]) {
                    deque.addFirst(workers[j]);
                    j--;
                }
                if (deque.isEmpty()) {
                    f = false;
                    break;
                } else if (deque.getLast() >= tasks[i]) {
                    deque.pollLast();
                } else {
                    if (pp <= 0) {
                        f = false;
                        break;
                    }
                    deque.pollFirst();
                    pp--;
                }
            }

            if (f) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
