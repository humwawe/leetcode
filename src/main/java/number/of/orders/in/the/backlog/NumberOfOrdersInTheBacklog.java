package number.of.orders.in.the.backlog;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @author hum
 */
public class NumberOfOrdersInTheBacklog {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (!sell.isEmpty() && order[0] >= sell.peek()[0] && order[1] > 0) {
                    int[] cur = sell.poll();
                    if (cur[1] > order[1]) {
                        cur[1] -= order[1];
                        order[1] = 0;
                        sell.offer(cur);
                    } else {
                        order[1] -= cur[1];
                    }
                }
                if (order[1] > 0) {
                    buy.offer(new int[]{order[0], order[1]});
                }
            } else {
                while (!buy.isEmpty() && order[0] <= buy.peek()[0] && order[1] > 0) {
                    int[] temp = buy.poll();
                    if (temp[1] > order[1]) {
                        temp[1] -= order[1];
                        order[1] = 0;
                        buy.offer(temp);
                    } else {
                        order[1] -= temp[1];
                    }
                }
                if (order[1] > 0) {
                    sell.offer(new int[]{order[0], order[1]});
                }
            }
        }

        int res = 0;
        int mod = 1_000_000_007;
        while (!buy.isEmpty()) {
            res = (res + buy.poll()[1]) % mod;
        }
        while (!sell.isEmpty()) {
            res = (res + sell.poll()[1]) % mod;
        }
        return res;
    }
}
