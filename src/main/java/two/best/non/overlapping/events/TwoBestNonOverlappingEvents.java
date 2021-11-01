package two.best.non.overlapping.events;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int max = 0;
        for (int[] e : events) {
            int start = e[0];
            int val = e[2];
            while (que.size() > 0 && que.peek()[1] < start) {
                max = Math.max(max, que.poll()[2]);
            }
            ans = Math.max(ans, max + val);
            que.offer(e);
        }
        return ans;
    }
}
