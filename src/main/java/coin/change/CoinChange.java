package coin.change;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        boolean[] visit = new boolean[amount];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(amount);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int coin : coins) {
                    if (coin == poll) {
                        return result;
                    }
                    if (coin < poll && !visit[poll - coin]) {
                        visit[poll - coin] = true;
                        queue.add(poll - coin);
                    }
                }
            }
        }
        return -1;
    }

}
