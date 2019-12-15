package strange.printer;

import java.util.Arrays;

/**
 * @author hum
 */
public class StrangePrinter {
    private int[][] memo;

    public int strangePrinter(String s) {
        int len = s.length();
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(s, 0, len - 1);
    }

    private int helper(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = helper(s, i + 1, j) + 1;
        for (int k = i + 1; k <= j; k++) {
            if (s.charAt(i) == s.charAt(k)) {
                res = Math.min(res, helper(s, i, k - 1) + helper(s, k + 1, j));
            }
        }
        return memo[i][j] = res;
    }
}
