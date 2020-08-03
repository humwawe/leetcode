package find.the.winner.of.an.array.game;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author hum
 */
public class FindTheWinnerOfAnArrayGame {
    public int getWinner(int[] arr, int k) {
        int len = arr.length;
        int max = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int value : arr) {
            max = Math.max(max, value);
            deque.add(value);
        }
        if (k >= len - 1) {
            return max;
        }
        int cnt = 0;
        while (true) {
            int x = deque.removeFirst();
            int y = deque.removeFirst();
            if (x > y) {
                cnt++;
                if (cnt >= k) {
                    return x;
                }
                deque.addFirst(x);
                deque.addLast(y);
            } else {
                cnt = 1;
                if (cnt >= k) {
                    return y;
                }
                deque.addFirst(y);
                deque.addLast(x);
            }
        }
    }
}
