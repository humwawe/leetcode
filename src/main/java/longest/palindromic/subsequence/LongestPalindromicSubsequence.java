package longest.palindromic.subsequence;

import java.util.Arrays;

/**
 * @author hum
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[][] memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(s, 0, len - 1, memo);
    }

    private int helper(String s, int i, int j, int[][] memo) {
        if (i > j) {
            memo[i][j] = 0;
            return memo[i][j];
        }
        if (i == j) {
            memo[i][j] = 1;
            return memo[i][j];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + helper(s, i + 1, j - 1, memo);
            return memo[i][j];
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
            return memo[i][j];
        }
    }
}
