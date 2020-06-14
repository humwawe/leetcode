package shortest.path.in.a.grid.with.obstacles.elimination;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class ShortestPathInAGridWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int inf = (int) 1e9;
        int[][][] dist = new int[row][col][k + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Arrays.fill(dist[i][j], inf);
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, k});
        dist[0][0][k] = 0;
        int[][] fs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] f : fs) {
                int x = poll[0] + f[0];
                int y = poll[1] + f[1];
                int c = poll[2];
                if (x < 0 || x >= row || y < 0 || y >= col) {
                    continue;
                }
                if (grid[x][y] == 1) {
                    if (c == 0 || dist[x][y][c - 1] != inf) {
                        continue;
                    }
                    dist[x][y][c - 1] = dist[poll[0]][poll[1]][c] + 1;
                    queue.add(new int[]{x, y, c - 1});
                } else {
                    if (dist[x][y][c] != inf) {
                        continue;
                    }
                    dist[x][y][c] = dist[poll[0]][poll[1]][c] + 1;
                    queue.add(new int[]{x, y, c});
                }
            }
        }
        int result = inf;
        for (int i = 0; i <= k; i++) {
            result = Math.min(result, dist[row - 1][col - 1][i]);
        }
        return result == inf ? -1 : result;
    }
}
