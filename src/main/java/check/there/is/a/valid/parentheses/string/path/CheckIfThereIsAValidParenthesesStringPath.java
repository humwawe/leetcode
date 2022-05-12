package check.there.is.a.valid.parentheses.string.path;

/**
 * @author hum
 */
public class CheckIfThereIsAValidParenthesesStringPath {
  int[][] g;
  int r, c;
  Boolean[][][] memo;

  public boolean hasValidPath(char[][] grid) {
    r = grid.length;
    c = grid[0].length;
    g = new int[r][c];
    memo = new Boolean[r + 5][c + 5][r + c + 5];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (grid[i][j] == '(') {
          g[i][j] = 1;
        } else {
          g[i][j] = -1;
        }
      }
    }
    if (g[0][0] == -1) {
      return false;
    }
    return dfs(0, 0, 1);
  }

  private boolean dfs(int i, int j, int sum) {
    if (i == r - 1 && j == c - 1) {
      return sum == 0;
    }
    if (memo[i][j][sum] != null) {
      return memo[i][j][sum];
    }
    boolean res = false;
    int nx = i + 1;
    int ny = j;
    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
      if (sum + g[nx][ny] >= 0) {
        res |= dfs(nx, ny, sum + g[nx][ny]);
      }
    }

    nx = i;
    ny = j + 1;
    if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
      if (sum + g[nx][ny] >= 0) {
        res |= dfs(nx, ny, sum + g[nx][ny]);
      }
    }

    return memo[i][j][sum] = res;
  }

}
