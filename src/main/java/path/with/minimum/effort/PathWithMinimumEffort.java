package path.with.minimum.effort;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class PathWithMinimumEffort {
    boolean[][] vis;
    int row, col;
    int[][] fs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] h;

    public int minimumEffortPath(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        h = heights;
        int l = 0;
        int r = (int) (1e6 + 1);
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int mid) {
        Queue<int[]> queue = new ArrayDeque<>();
        vis = new boolean[row][col];
        queue.add(new int[]{0, 0});
        vis[0][0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == row - 1 && poll[1] == col - 1) {
                return true;
            }
            for (int[] f : fs) {
                int x = poll[0] + f[0];
                int y = poll[1] + f[1];
                if (x >= 0 && x < row && y >= 0 && y < col && !vis[x][y]) {
                    int tmp = Math.abs(h[poll[0]][poll[1]] - h[x][y]);
                    if (tmp <= mid) {
                        queue.add(new int[]{x, y});
                        vis[x][y] = true;
                    }
                }
            }
        }
        return false;
    }
}
