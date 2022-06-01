package minimum.obstacle.removal.to.reach.corner;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author hum
 */
public class MinimumObstacleRemovalToReachCorner {
  public int minimumObstacles(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0});
    int[][] dist = new int[n][m];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], -1);
    }

    dist[0][0] = 0;
    int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while (!queue.isEmpty()) {
      int[] cur = queue.pollFirst();
      for (int[] f : fs) {
        int x = f[0] + cur[0];
        int y = f[1] + cur[1];

        if (x >= 0 && x < n && y >= 0 && y < m && dist[x][y] == -1) {
          if (grid[x][y] == 0) {
            queue.addFirst(new int[]{x, y});
            dist[x][y] = dist[cur[0]][cur[1]];
          } else {
            queue.addLast(new int[]{x, y});
            dist[x][y] = dist[cur[0]][cur[1]] + 1;
          }
        }
      }
    }
    return dist[n - 1][m - 1];
  }
}
