package escape.a.large.maze;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author hum
 */
public class EscapeALargeMaze {
    int max;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int len = blocked.length;
        max = len * (len - 1) / 2;
        return helper(blocked, source, target) && helper(blocked, target, source);
    }

    private boolean helper(int[][] blocked, int[] source, int[] target) {
        Set<Long> set = new HashSet<>();
        int[][] fs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] ints : blocked) {
            set.add(ints[0] * 1000000L + ints[1]);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(source);
        int count = 1;
        set.add(source[0] * 1000000L + source[1]);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] f : fs) {
                int x = poll[0] + f[0];
                int y = poll[1] + f[1];
                if (x == target[0] && y == target[1]) {
                    return true;
                }
                if (x >= 0 && x < 1e6 && y >= 0 && y < 1e6 && !set.contains(x * 1000000L + y)) {
                    queue.add(new int[]{x, y});
                    set.add(x * 1000000L + y);
                    count++;
                }
            }
            if (count > max) {
                return true;
            }
        }
        return false;
    }
}
