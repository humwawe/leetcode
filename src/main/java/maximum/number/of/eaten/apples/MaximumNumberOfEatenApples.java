package maximum.number.of.eaten.apples;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MaximumNumberOfEatenApples {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int res = 0;
        for (int i = 0; ; i++) {
            if (i < apples.length && apples[i] > 0) {
                q.offer(new int[]{i + days[i], apples[i]});
            } else if (i >= apples.length && q.isEmpty()) {
                break;
            }
            while (!q.isEmpty() && (q.peek()[0] <= i || q.peek()[1] <= 0)) {
                q.poll();
            }
            if (!q.isEmpty()) {
                q.peek()[1] -= 1;
                res++;
            }
        }
        return res;
    }

}
