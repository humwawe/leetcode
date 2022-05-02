package count.unguarded.cells.in.the.grid;

/**
 * @author hum
 */
public class CountUnguardedCellsInTheGrid {

  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    int res = 0;
    int[][] fs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    char[][] grid = new char[m][n];
    for (int[] guard : guards) {
      grid[guard[0]][guard[1]] = 'G';
    }
    for (int[] wall : walls) {
      grid[wall[0]][wall[1]] = 'W';
    }
    for (int[] guard : guards) {
      int x = guard[0];
      int y = guard[1];
      for (int[] f : fs) {
        int nx = x + f[0];
        int ny = y + f[1];
        while (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 'G' && grid[nx][ny] != 'W') {
          grid[nx][ny] = 'I';
          nx += f[0];
          ny += f[1];
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] != 'G' && grid[i][j] != 'W' && grid[i][j] != 'I') {
          res++;
        }
      }
    }
    return res;
  }

}
