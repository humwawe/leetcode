package snakes.and.ladders;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int len = board.length;
        boolean[] vis = new boolean[len * len + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            System.out.println(queue);
            while (size-- > 0) {
                int poll = queue.poll();
                for (int i = 1; i <= 6; i++) {
                    int x = poll + i;
                    if (x == len * len) {
                        return step;
                    }
                    if (vis[x] || x > len * len) {
                        continue;
                    }
                    vis[x] = true;
                    int[] p = helper(x, len);
                    int t = board[p[0]][p[1]];
                    if (t != -1 && !vis[t]) {
                        if (t == len * len) {
                            return step;
                        }
                        queue.add(t);
                    }
                    if (t == -1) {
                        queue.add(x);
                    }
                }
            }
        }
        return -1;
    }

    private int[] helper(int i, int len) {
        int x = len - 1 - (i - 1) / len;
        int y = (i - 1) / len % 2 == 0 ? (i - 1) % len : len - 1 - (i - 1) % len;
        return new int[]{x, y};
    }
}
