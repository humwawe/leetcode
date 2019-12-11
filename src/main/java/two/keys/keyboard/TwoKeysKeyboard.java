package two.keys.keyboard;

import java.util.Arrays;

/**
 * @author hum
 */
public class TwoKeysKeyboard {
    int[][] memo;

    public int minSteps(int n) {
        memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(n, 1, 1, true);
    }

    private int helper(int n, int copyA, int curN, boolean first) {
        if (curN > n) {
            return 10000;
        }
        if (curN == n) {
            return memo[copyA][curN] = 0;
        }
        if (memo[copyA][curN] != -1) {
            return memo[copyA][curN];
        }
        if (first) {
            return helper(n, curN, curN * 2, false) + 2;
        }
        return memo[copyA][curN] = Math.min(helper(n, curN, curN * 2, false) + 2, helper(n, copyA, curN + copyA, false) + 1);
    }
}
