package build.arrray.where.you.can.find.the.maximum.exactly.k.comparisons;

/**
 * @author hum
 */
public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {
    int m;
    Integer[][][] memo = new Integer[55][55][105];
    int mod = (int) (1e9 + 7);

    public int numOfArrays(int n, int m, int k) {
        this.m = m;
        return helper(n, k, -1);
    }

    private int helper(int n, int k, int max) {
        if (n == 0) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        if (k < 0) {
            return 0;
        }
        if (memo[n][k][max] != null) {
            return memo[n][k][max];
        }
        int res = 0;
        for (int i = 1; i <= m; i++) {
            if (max < i) {
                res += helper(n - 1, k - 1, i);
            } else {
                res += helper(n - 1, k, max);
            }
            res %= mod;
        }

        return memo[n][k][max] = res % mod;
    }
}
