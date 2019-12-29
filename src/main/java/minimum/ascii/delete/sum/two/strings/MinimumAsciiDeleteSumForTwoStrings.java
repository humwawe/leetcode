package minimum.ascii.delete.sum.two.strings;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumAsciiDeleteSumForTwoStrings {
    int[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        memo = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(s1, s2, 0, 0);
    }

    private int helper(String s1, String s2, int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.length() == i && s2.length() == j) {
            return memo[i][j] = 0;
        }
        if (s1.length() == i) {
            return memo[i][j] = helper(s1, s2, i, j + 1) + s2.charAt(j);
        }
        if (s2.length() == j) {
            return memo[i][j] = helper(s1, s2, i + 1, j) + s1.charAt(i);
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return memo[i][j] = helper(s1, s2, i + 1, j + 1);
        }
        return memo[i][j] = Math.min(helper(s1, s2, i + 1, j) + s1.charAt(i), helper(s1, s2, i, j + 1) + s2.charAt(j));
    }
}
