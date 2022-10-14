package paths.in.matrix.whose.sum.is.divisible.by.k;

/**
 * @author hum
 */
public class PathsInMatrixWhoseSumIsDivisibleByK {
  int[][] g;
  int k;
  int n, m;
  int mod = (int) (1e9 + 7);
  int[][][] dp;

  public int numberOfPaths(int[][] grid, int k) {
    n = grid.length;
    m = grid[0].length;
    this.g = grid;
    this.k = k;
    dp = new int[n + 1][m + 1][k];
    dp[1][1][grid[0][0] % k] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        for (int l = 0; l < k; l++) {
          add(i, j, l);
        }
      }
    }
    return dp[n][m][0];
  }

  private void add(int i, int j, int l) {

    int cur = g[i - 1][j - 1];
    int x = ((l - cur) % k + k) % k;

    dp[i][j][l] = (dp[i][j][l] + dp[i - 1][j][x]) % mod;
    dp[i][j][l] = (dp[i][j][l] + dp[i][j - 1][x]) % mod;
  }
}
