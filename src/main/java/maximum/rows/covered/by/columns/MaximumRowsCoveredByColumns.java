package maximum.rows.covered.by.columns;

/**
 * @author hum
 */
public class MaximumRowsCoveredByColumns {
  int n, m;
  int[][] mat;
  int ans;

  public int maximumRows(int[][] mat, int cols) {
    n = mat.length;
    m = mat[0].length;
    this.mat = mat;
    int comb = (1 << cols) - 1;
    while (comb < 1 << m) {
      helper(comb);
      int x = comb & -comb;
      int y = comb + x;
      comb = ((comb & ~y) / x >> 1) | y;
    }
    return ans;
  }

  private void helper(int c) {
    int res = 0;
    f:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (this.mat[i][j] == 1 && ((c >> j) & 1) == 0) {
          continue f;
        }
      }
      res++;
    }
    ans = Math.max(ans, res);
  }
}
