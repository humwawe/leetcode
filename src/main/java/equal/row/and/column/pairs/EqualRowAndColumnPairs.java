package equal.row.and.column.pairs;

/**
 * @author hum
 */
public class EqualRowAndColumnPairs {
  public int equalPairs(int[][] grid) {
    int res = 0;
    for (int[] g : grid) {
      for (int j = 0; j < grid.length; j++) {
        boolean f = true;
        for (int k = 0; k < grid.length; k++) {
          if (g[k] != grid[k][j]) {
            f = false;
            break;
          }
        }
        if (f) {
          res++;
        }
      }
    }
    return res;
  }
}
