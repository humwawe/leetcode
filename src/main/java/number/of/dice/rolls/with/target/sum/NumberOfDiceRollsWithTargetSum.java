package number.of.dice.rolls.with.target.sum;

import java.util.Arrays;

/**
 * @author hum
 */
public class NumberOfDiceRollsWithTargetSum {
    int f;
    int d;
    int mod = (int) (1e9 + 7);
    int[][] memo;

    public int numRollsToTarget(int d, int f, int target) {
        memo = new int[d][target + 1];
        for (int i = 0; i < d; i++) {
            Arrays.fill(memo[i], -1);
        }
        this.f = f;
        this.d = d;
        return helper(target, 0);
    }

    private int helper(int target, int i) {
        if (target <= 0) {
            return 0;
        }
        if (i == d - 1) {
            if (target <= f) {
                return 1;
            }
            return 0;
        }
        if (memo[i][target] != -1) {
            return memo[i][target];
        }
        long res = 0;
        for (int j = 1; j <= f; j++) {
            res += helper(target - j, i + 1) % mod;
        }
        return memo[i][target] = (int) (res % mod);
    }
}
