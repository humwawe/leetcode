package largest.magic.square;

/**
 * @author hum
 */
public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum1 = new int[m + 5][n + 5];
        int[][] sum2 = new int[m + 5][n + 5];
        int[][] sum3 = new int[m + 5][n + 5];
        int[][] sum4 = new int[m + 5][n + 5];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum1[i][j] = sum1[i][j - 1] + grid[i - 1][j - 1];
                sum2[i][j] = sum2[i - 1][j] + grid[i - 1][j - 1];
                sum3[i][j] = sum3[i - 1][j - 1] + grid[i - 1][j - 1];
                sum4[i][j] = sum4[i - 1][j + 1] + grid[i - 1][j - 1];
            }
        }
        int res = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f:
                for (int k = res; k <= Math.min(m - i, n - j) + 1; k++) {
                    int tmp = sum1[i][j + k - 1] - sum1[i][j - 1];
                    int t;
                    for (int l = 0; l < k; l++) {
                        t = sum1[i + l][j + k - 1] - sum1[i + l][j - 1];
                        if (t != tmp) {
                            continue f;
                        }
                    }

                    for (int l = 0; l < k; l++) {
                        t = sum2[i + k - 1][j + l] - sum2[i - 1][j + l];
                        if (t != tmp) {
                            continue f;
                        }
                    }
                    t = sum3[i + k - 1][j + k - 1] - sum3[i - 1][j - 1];
                    if (t != tmp) {
                        continue;
                    }
                    t = sum4[i + k - 1][j] - sum4[i - 1][j + k];
                    if (t != tmp) {
                        continue;
                    }
                    res = k;
                }
            }
        }
        return res;
    }
}
