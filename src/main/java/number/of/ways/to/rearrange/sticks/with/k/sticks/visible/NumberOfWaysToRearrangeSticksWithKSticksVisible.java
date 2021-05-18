package number.of.ways.to.rearrange.sticks.with.k.sticks.visible;

/**
 * @author hum
 */
public class NumberOfWaysToRearrangeSticksWithKSticksVisible {
    int mod = (int) (1e9 + 7);
    Long[][] memo = new Long[1005][1005];

    public int rearrangeSticks(int n, int k) {
        long res = helper(n, k);
        return (int) (res % mod);
    }

    private long helper(int n, int k) {
        if (n == k) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (memo[n][k] != null) {
            return memo[n][k];
        }
        return memo[n][k] = helper(n - 1, k - 1) + helper(n - 1, k) * (n - 1) % mod;
    }
}
