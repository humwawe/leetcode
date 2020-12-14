package delivering.boxes.from.storage.to.ports;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class DeliveringBoxesFromStorageToPorts {

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int len = boxes.length;
        int[] dp = new int[len + 1];
        int[] g = new int[len + 1];
        int[] c = new int[len + 2];
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            if (i > 1) {
                c[i] = c[i - 1] + (boxes[i - 2][0] != boxes[i - 1][0] ? 1 : 0);
            }
            sum[i] = sum[i - 1] + boxes[i - 1][1];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);

        for (int i = 1; i <= len; i++) {
            while (!deque.isEmpty() && (i - deque.peekFirst() > maxBoxes || sum[i] - sum[deque.peekFirst()] > maxWeight)) {
                deque.pollFirst();
            }

            dp[i] = g[deque.peekFirst()] + c[i] + 2;

            g[i] = dp[i] - c[i + 1];
            while (!deque.isEmpty() && g[i] < g[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return dp[len];
    }

}
