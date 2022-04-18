package maximum.trailing.zeros.in.a.cornered.path;

/**
 * @author hum
 */
public class MaximumTrailingZerosInACorneredPath {
  public int maxTrailingZeros(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int[][] cnt2 = new int[row][col + 1];
    int[][] cnt5 = new int[row][col + 1];
    int[][] cnt2Col = new int[col][row + 1];
    int[][] cnt5Col = new int[col][row + 1];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        cnt2[i][j + 1] = cnt2[i][j];
        cnt5[i][j + 1] = cnt5[i][j];
        cnt2Col[j][i + 1] = cnt2Col[j][i];
        cnt5Col[j][i + 1] = cnt5Col[j][i];
        int t = grid[i][j];
        while (t % 5 == 0) {
          cnt5[i][j + 1] += 1;
          cnt5Col[j][i + 1] += 1;
          t /= 5;
        }
        while (t % 2 == 0) {
          cnt2[i][j + 1] += 1;
          cnt2Col[j][i + 1] += 1;
          t /= 2;
        }
      }
    }

    int res = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {

        int t = Math.min(cnt2[i][j + 1] + cnt2Col[j][i], cnt5[i][j + 1] + cnt5Col[j][i]);
        res = Math.max(res, t);

        t = Math.min(cnt2[i][col] - cnt2[i][j] + cnt2Col[j][i], cnt5[i][col] - cnt5[i][j] + cnt5Col[j][i]);
        res = Math.max(res, t);

        t = Math.min(cnt2[i][j] + (cnt2Col[j][row] - cnt2Col[j][i]), cnt5[i][j] + (cnt5Col[j][row] - cnt5Col[j][i]));
        res = Math.max(res, t);

        t = Math.min(cnt2[i][col] - cnt2[i][j + 1] + (cnt2Col[j][row] - cnt2Col[j][i]), cnt5[i][col] - cnt5[i][j + 1] + (cnt5Col[j][row] - cnt5Col[j][i]));
        res = Math.max(res, t);
      }
    }
    return res;
  }
}
