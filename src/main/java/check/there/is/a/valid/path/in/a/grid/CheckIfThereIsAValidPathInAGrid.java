package check.there.is.a.valid.path.in.a.grid;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class CheckIfThereIsAValidPathInAGrid {
    public boolean hasValidPath(int[][] grid) {
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] conn = new int[][]{{2, 3}, {0, 1}, {1, 2}, {1, 3}, {0, 2}, {0, 3}};
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        vis[row - 1][col - 1] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row - 1, col - 1});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int nei : conn[grid[cur[0]][cur[1]] - 1]) {
                int x = cur[0] + fs[nei][0];
                int y = cur[1] + fs[nei][1];
                int target = nei < 2 ? 1 - nei : 5 - nei;
                if (x < 0 || x > row - 1 || y < 0 || y > col - 1 || vis[x][y]) {
                    continue;
                }
                if (conn[grid[x][y] - 1][0] == target || conn[grid[x][y] - 1][1] == target) {
                    vis[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return vis[0][0];
    }
}
