package number.of.increasing.paths.in.a.grid;

/**
 * @author hum
 */
public class NumberOfIncreasingPathsInAGrid {
  int n, m;
  int[][] g;
  int mod = (int) (1e9 + 7);
  int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  Long[][] memo = new Long[1005][1005];

  public int countPaths(int[][] grid) {
    this.g = grid;
    n = g.length;
    m = g[0].length;
    long res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        res += dfs(i, j);
        res %= mod;
      }
    }
    return (int) (res % mod);
  }

  private long dfs(int i, int j) {
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    long res = 1;
    for (int[] f : fs) {
      int x = f[0] + i;
      int y = f[1] + j;
      if (x >= 0 && y >= 0 && x < n && y < m && g[x][y] > g[i][j]) {
        res += dfs(x, y);
        res %= mod;
      }
    }
    return memo[i][j] = res;
  }
}
