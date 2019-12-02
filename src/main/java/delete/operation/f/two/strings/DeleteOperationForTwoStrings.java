package delete.operation.f.two.strings;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {
    private int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return helper(word1, word2, 0, 0);
    }

    private int helper(String word1, String word2, int i, int j) {
        if (word1.length() == i) {
            return word2.length() - j;
        }
        if (word2.length() == j) {
            return word1.length() - i;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = helper(word1, word2, i + 1, j + 1);
        }
        return memo[i][j] = Math.min(helper(word1, word2, i + 1, j), helper(word1, word2, i, j + 1)) + 1;
    }
}
