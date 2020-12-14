package delivering.boxes.from.storage.to.ports;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class DeliveringBoxesFromStorageToPorts {
    int[] sum;

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {

        int len = boxes.length;
        int[] dp = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += boxes[i][1];
            while (!deque.isEmpty() && i - deque.getFirst() > maxBoxes && sum > maxWeight) {
                sum -= boxes[deque.pollFirst()][1];
            }
            if (!deque.isEmpty()) {
                int k = deque.getFirst();
                dp[i] = dp[k] + cost(k, i) + 1;
            }
            while (!deque.isEmpty() && dp[deque.peekLast()] + cost(deque.peekLast(), i) >= dp[i]) {
                deque.pollLast();
            }
            deque.addLast(i);


        }

    }

    private int cost(int l, int r) {
        int ans = sum[r] - sum[l];
        if (l + 1 <= r && sum[l + 1] == sum[l]) {
            ans++;
        }
        return ans;
    }
}
