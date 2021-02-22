package maximize.palindrome.length.from.subsequences;

/**
 * @author hum
 */
public class MaximizePalindromeLengthFromSubsequences {
    int n, m;
    int inf = (int) -1e8;
    Integer[][][] memo;

    public int longestPalindrome(String word1, String word2) {
        n = word1.length();
        m = word2.length();
        String w = word1 + word2;
        int len = w.length();
        memo = new Integer[len][len][2];
        return Math.max(dfs(w, 0, len - 1, 0), 0);
    }


    private int dfs(String tmp, int i, int j, int use) {
        if (i == j) {
            return use != 1 ? inf : 1;
        }
        if (i > j) {
            return use != 1 ? inf : 0;
        }
        if (memo[i][j][use] != null) {
            return memo[i][j][use];
        }
        if (tmp.charAt(i) == tmp.charAt(j)) {
            int t = 0;
            if (i < n && j >= n) {
                t |= 1;
            }
            return memo[i][j][use] = 2 + dfs(tmp, i + 1, j - 1, use | t);
        }
        return memo[i][j][use] = Math.max(dfs(tmp, i + 1, j, use), dfs(tmp, i, j - 1, use));
    }
}
