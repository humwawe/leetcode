package longest.common.subsequence;

import java.util.Arrays;

/**
 * @author hum
 */
public class LongestCommonSubsequence {
    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        memo = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(text1, text2, 0, 0);
    }

    private int helper(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return helper(text1, text2, i + 1, j + 1) + 1;
        }
        return memo[i][j] = Math.max(helper(text1, text2, i + 1, j), helper(text1, text2, i, j + 1));
    }
}
