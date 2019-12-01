package out.of.boundary.paths;

import java.util.Arrays;

/**
 * @author hum
 */
public class OutOfBoundaryPaths {
    private int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private long[][][] memo;
    private int mod = (int) Math.pow(10, 9) + 7;

    public int findPaths(int m, int n, int k, int i, int j) {
        memo = new long[m][n][k + 1];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                Arrays.fill(memo[x][y], -1);
            }
        }
        return (int) helper(m, n, k, i, j);
    }

    public long helper(int m, int n, int k, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        }
        if (k <= 0) {
            return memo[i][j][k] = 0;
        }
        long tmp = 0;
        for (int[] f : fs) {
            tmp += helper(m, n, k - 1, i + f[0], j + f[1]) % mod;
        }
        return memo[i][j][k] = tmp % mod;
    }
}
