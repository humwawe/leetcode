package uncrossed.lines;

import java.util.Arrays;

/**
 * @author hum
 */
public class UncrossedLines {
    int[][] memo;

    public int maxUncrossedLines(int[] a, int[] b) {
        memo = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(a, b, 0, 0);
    }

    private int helper(int[] a, int[] b, int i, int j) {
        if (i == a.length || j == b.length) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (a[i] == b[j]) {
            return memo[i][j] = helper(a, b, i + 1, j + 1) + 1;
        }
        return memo[i][j] = Math.max(helper(a, b, i + 1, j), helper(a, b, i, j + 1));
    }
}
