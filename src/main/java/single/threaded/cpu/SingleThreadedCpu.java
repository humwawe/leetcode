package single.threaded.cpu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class SingleThreadedCpu {
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        int[][] t = new int[len][3];
        for (int i = 0; i < len; i++) {
            t[i][0] = tasks[i][0];
            t[i][1] = tasks[i][1];
            t[i][2] = i;
        }
        Arrays.sort(t, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> {
            int c = t[x][1] - t[y][1];
            if (c == 0) {
                return t[x][2] - t[y][2];
            }
            return c;
        });
        int idx = 0;
        long start = t[idx][0];
        int[] res = new int[len];
        int i = 0;

        while (idx < len) {
            while (idx < len && t[idx][0] <= start) {
                priorityQueue.add(idx);
                idx++;
            }
            if (priorityQueue.isEmpty() && idx < len) {
                start = t[idx][0];
            }
            if (!priorityQueue.isEmpty()) {
                Integer cur = priorityQueue.poll();
                res[i++] = t[cur][2];
                start = start + t[cur][1];
            }
        }
        while (!priorityQueue.isEmpty()) {
            res[i++] = t[priorityQueue.poll()][2];
        }
        return res;
    }
}
