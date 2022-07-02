package check.matrix.is.x.matrix;

/**
 * @author hum
 */
public class CheckIfMatrixIsXMatrix {
  public boolean checkXMatrix(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i - j == 0 || i + j == n - 1) {
          if (grid[i][j] == 0) {
            return false;
          }
        } else {
          if (grid[i][j] != 0) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
