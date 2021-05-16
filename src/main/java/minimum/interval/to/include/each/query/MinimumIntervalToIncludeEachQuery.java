package minimum.interval.to.include.each.query;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Integer[] pos = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            pos[i] = i;
        }
        Arrays.sort(pos, Comparator.comparingInt(x -> queries[x]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - x[0] - y[1] + y[0]);
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int[] res = new int[queries.length];
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = pos[i];
            int v = queries[index];
            while (j < intervals.length && intervals[j][0] <= v) {
                queue.add(intervals[j]);
                j++;
            }
            while (!queue.isEmpty() && queue.peek()[1] < v) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                int[] peek = queue.peek();
                res[index] = peek[1] - peek[0] + 1;
            } else {
                res[index] = -1;
            }
        }
        return res;
    }
}
