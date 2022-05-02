package escape.the.spreading.fire;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class EscapeTheSpreadingFire {

  int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int maximumMinutes(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    Queue<int[]> fires = new ArrayDeque<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          fires.add(new int[]{i, j});
        }
      }
    }

    int l = -1;
    int r = m * n;
    while (l < r) {
      int mid = (l + r + 1) / 2;
      if (check(mid, copy(grid), new ArrayDeque<>(fires))) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l < m * n ? l : (int) 1e9;
  }

  private boolean check(int waitTime, int[][] grid, Queue<int[]> fires) {
    while (waitTime-- > 0) {
      spreadFires(grid, fires);
    }
    if (grid[0][0] == 1) {
      return false;
    }

    int m = grid.length;
    int n = grid[0].length;
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{0, 0});
    boolean[][] vis = new boolean[m][n];
    vis[0][0] = true;
    while (!q.isEmpty()) {
      int s = q.size();
      for (int i = 0; i < s; i++) {
        int[] poll = q.poll();
        int x = poll[0];
        int y = poll[1];
        if (grid[x][y] == 1) {
          continue;
        }
        for (int[] f : fs) {
          int nx = poll[0] + f[0];
          int ny = poll[1] + f[1];
          if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny] && grid[nx][ny] == 0) {
            if (nx == m - 1 && ny == n - 1) {
              return true;
            }
            vis[nx][ny] = true;
            q.add(new int[]{nx, ny});
          }
        }
      }
      spreadFires(grid, fires);
    }
    return false;
  }

  private void spreadFires(int[][] grid, Queue<int[]> fires) {
    int m = grid.length, n = grid[0].length;
    if (fires.isEmpty()) {
      return;
    }
    int size = fires.size();
    for (int i = 0; i < size; i++) {
      int[] poll = fires.poll();
      for (int[] f : fs) {
        int nx = poll[0] + f[0];
        int ny = poll[1] + f[1];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
          grid[nx][ny] = 1;
          fires.add(new int[]{nx, ny});
        }
      }
    }
  }


  private int[][] copy(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] ret = new int[m][n];
    for (int i = 0; i < m; i++) {
      System.arraycopy(grid[i], 0, ret[i], 0, n);
    }
    return ret;
  }
}
