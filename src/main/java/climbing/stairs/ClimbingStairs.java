package climbing.stairs;

/**
 * @author hum
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int dp0 = 1, dp1 = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = dp0 + dp1;
            dp0 = dp1;
            dp1 = result;
        }
        return result;

    }
}
