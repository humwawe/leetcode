package longest.chunked.palindrome.decomposition;

import java.util.Arrays;

/**
 * @author hum
 */
public class LongestChunkedPalindromeDecomposition {
    int[][] memo;

    public int longestDecomposition(String text) {
        int len = text.length();
        memo = new int[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(text, 0, len);
    }

    private int helper(String text, int i, int j) {
        if (i == j - 1) {
            return 1;
        }
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        for (int k = 1; k <= (j - i) / 2; k++) {
            if (text.substring(i, i + k).equals(text.substring(j - k, j))) {
                return memo[i][j] = helper(text, i + k, j - k) + 2;
            }
        }
        return memo[i][j] = 1;
    }
}
