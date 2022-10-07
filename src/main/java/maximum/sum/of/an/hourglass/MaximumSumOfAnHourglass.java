package maximum.sum.of.an.hourglass;

/**
 * @author hum
 */
public class MaximumSumOfAnHourglass {
  public int maxSum(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int res = 0;
    for (int i = 0; i + 2 < n; i++) {
      for (int j = 0; j + 2 < m; j++) {
        int tmp = 0;
        for (int k = 0; k < 3; k++) {
          tmp += grid[i][j + k];
        }
        tmp += grid[i + 1][j + 1];
        for (int k = 0; k < 3; k++) {
          tmp += grid[i + 2][j + k];
        }
        res = Math.max(res, tmp);
      }
    }
    return res;
  }
}