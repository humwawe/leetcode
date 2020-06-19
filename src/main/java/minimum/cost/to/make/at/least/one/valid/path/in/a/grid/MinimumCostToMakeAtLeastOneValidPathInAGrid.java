package minimum.cost.to.make.at.least.one.valid.path.in.a.grid;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author hum
 */
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {
    public int minCost(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] fs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] dist = new int[row][col];
        int inf = (int) 1e8;
        for (int i = 0; i < row; i++) {
            Arrays.fill(dist[i], inf);
        }
        int f = grid[0][0];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(new int[]{0, 0, f - 1});
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + fs[i][0];
                int y = cur[1] + fs[i][1];
                if (x < 0 || x >= row || y < 0 || y >= col) {
                    continue;
                }
                f = grid[x][y] - 1;
                if (i == cur[2]) {
                    if (dist[x][y] > dist[cur[0]][cur[1]]) {
                        dist[x][y] = dist[cur[0]][cur[1]];
                        queue.addFirst(new int[]{x, y, f});
                    }
                } else {
                    if (dist[x][y] > dist[cur[0]][cur[1]] + 1) {
                        dist[x][y] = dist[cur[0]][cur[1]] + 1;
                        queue.addLast(new int[]{x, y, f});
                    }
                }
            }
        }
        return dist[row - 1][col - 1];
    }
}
