package palindrome.partitioning.IV;

/**
 * @author hum
 */
public class PalindromePartitioningIV {
    int n;
    Boolean[][] memo;
    String s;

    public boolean checkPartitioning(String s) {
        n = s.length();
        this.s = s;
        memo = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                if (memo[0][i] == null) {
                    helper(0, i);
                }
                if (memo[i + 1][j - 1] == null) {
                    helper(i + 1, j - 1);
                }
                if (memo[j][n - 1] == null) {
                    helper(j, n - 1);
                }
                if (memo[0][i] && memo[i + 1][j - 1] && memo[j][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j) {
        if (i >= j) {
            return memo[i][j] = true;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = helper(i + 1, j - 1);
        }
        return memo[i][j] = false;
    }
}
