package number.of.ways.to.stay.in.the.same.place.after.some.steps;

/**
 * @author hum
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    int len;
    int mod = (int) (1e9 + 7);
    Long[][] memo;

    public int numWays(int steps, int arrLen) {
        len = Math.min(steps, arrLen);
        memo = new Long[steps + 1][len];
        return helper(steps, 0);
    }

    private int helper(int steps, int i) {
        if (steps == 0) {
            if (i == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[steps][i] != null) {
            return (int) (memo[steps][i] % mod);
        }
        long c1 = 0, c2 = 0, c3 = 0;
        c1 = helper(steps - 1, i) % mod;
        if (i + 1 < len) {
            c2 = helper(steps - 1, i + 1) % mod;
        }
        if (i - 1 >= 0) {
            c3 = helper(steps - 1, i - 1) % mod;
        }
        memo[steps][i] = c1 + c2 + c3;
        return (int) (memo[steps][i] % mod);
    }
}
