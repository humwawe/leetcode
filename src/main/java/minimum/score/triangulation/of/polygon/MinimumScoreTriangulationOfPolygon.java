package minimum.score.triangulation.of.polygon;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumScoreTriangulationOfPolygon {
    int[][] memo;

    public int minScoreTriangulation(int[] a) {
        int len = a.length;
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(a, 0, len - 1);
    }

    private int helper(int[] a, int i, int j) {
        if (i + 2 > j) {
            return 0;
        }
        if (i + 2 == j) {
            return memo[i][j] = a[i] * a[i + 1] * a[j];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0x3f3f3f3f;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, helper(a, i, k) + helper(a, k, j) + a[i] * a[k] * a[j]);
        }
        return memo[i][j] = res;

    }
}
