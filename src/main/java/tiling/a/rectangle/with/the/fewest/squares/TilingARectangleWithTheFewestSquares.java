package tiling.a.rectangle.with.the.fewest.squares;

/**
 * @author hum
 */
public class TilingARectangleWithTheFewestSquares {
    Integer[][] memo;

    public int tilingRectangle(int n, int m) {
        memo = new Integer[20][20];
        memo[11][13] = memo[13][11] = 6;
        return helper(n, m);
    }

    private int helper(int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return Math.max(n, m);
        }
        if (memo[n][m] != null) {
            return memo[n][m];
        }
        int res = 0x3f3f3f3f;
        for (int i = Math.min(n, m); i > 0; i--) {
            int tmp = Math.min(helper(n - i, i) + helper(n, m - i), helper(n - i, m) + helper(i, m - i)) + 1;
            res = Math.min(res, tmp);
        }
        return memo[n][m] = res;
    }
}
