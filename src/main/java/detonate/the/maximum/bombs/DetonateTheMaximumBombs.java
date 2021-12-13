package detonate.the.maximum.bombs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        int len = bombs.length;
        List<Integer>[] lists = new List[len];
        for (int i = 0; i < len; i++) {
            lists[i] = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (helper(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1], bombs[i][2])) {
                    lists[i].add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            boolean[] vis = new boolean[len];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            vis[i] = true;
            int cnt = 1;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (Integer j : lists[cur]) {
                    if (!vis[j]) {
                        queue.add(j);
                        vis[j] = true;
                        cnt++;
                    }
                }
            }
            res = Math.max(res, cnt);
        }
        return res;

    }

    boolean helper(long x1, long y1, long x2, long y2, long r1) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r1 * r1;
    }
}
