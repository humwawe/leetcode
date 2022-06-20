package selling.pieces.of.wood;

/**
 * @author hum
 */
public class SellingPiecesOfWood {
  public long sellingWood(int m, int n, int[][] prices) {
    long[][] f = new long[m + 1][n + 1];
    for (int[] p : prices) {
      f[p[0]][p[1]] = p[2];
    }

    for (var i = 1; i <= m; i++) {
      for (var j = 1; j <= n; j++) {
        for (var k = 1; k < j; k++) {
          f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
        }
        for (var k = 1; k < i; k++) {
          f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
        }
      }
    }
    return f[m][n];
  }

}
