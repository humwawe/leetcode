package largest.merge.of.two.strings;

/**
 * @author hum
 */
public class LargestMergeOfTwoStrings {
    Integer[][] memo;

    public String largestMerge(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        memo = new Integer[len1][len2];
        int i = 0;
        int j = 0;
        StringBuilder res = new StringBuilder();
        while (i < len1 && j < len2) {
            if (word1.charAt(i) > word2.charAt(j)) {
                res.append(word1.charAt(i));
                i++;
            } else if (word1.charAt(i) < word2.charAt(j)) {
                res.append(word2.charAt(j));
                j++;
            } else {
                Integer tmp = memo[i][j];
                if (memo[i][j] == null) {
                    tmp = helper(word1, word2, i, j);
                }
                if (tmp >= 0) {
                    res.append(word1.charAt(i));
                    i++;
                } else {
                    res.append(word2.charAt(j));
                    j++;
                }
            }
        }
        while (i < len1) {
            res.append(word1.charAt(i++));
        }
        while (j < len2) {
            res.append(word2.charAt(j++));
        }
        return res.toString();
    }

    private int helper(String word1, String word2, int i, int j) {
        if (i == word1.length()) {
            return -1;
        }
        if (j == word2.length()) {
            return 1;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = helper(word1, word2, i + 1, j + 1);
        } else if (word1.charAt(i) > word2.charAt(j)) {
            return memo[i][j] = 1;
        } else if (word1.charAt(i) < word2.charAt(j)) {
            return memo[i][j] = -1;
        }
        return 0;
    }
}
