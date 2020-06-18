package maximum.number.of.events.that.can.be.attended;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int len = events.length;
        int result = 0;
        int j = 0;
        for (int i = 1; i < 1e5 + 1; i++) {
            while (j < len && events[j][0] == i) {
                priorityQueue.add(events[j][1]);
                j++;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek() < i) {
                priorityQueue.poll();
            }
            if (!priorityQueue.isEmpty()) {
                result++;
                priorityQueue.poll();
            }
        }
        return result;
    }
}
