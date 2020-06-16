package jump.game.III;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        int len = arr.length;
        boolean[] vis = new boolean[len];
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (arr[poll] == 0) {
                return true;
            }
            int x = poll + arr[poll];
            if (x >= 0 && x < len && !vis[x]) {
                queue.add(x);
                vis[x] = true;
            }
            int y = poll - arr[poll];
            if (y >= 0 && y < len && !vis[y]) {
                queue.add(y);
                vis[y] = true;
            }
        }
        return false;
    }
}
