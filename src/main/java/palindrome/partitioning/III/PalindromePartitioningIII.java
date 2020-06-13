package palindrome.partitioning.III;

/**
 * @author hum
 */
public class PalindromePartitioningIII {
    int len;
    int[][] map;
    Integer[][] memo;

    public int palindromePartition(String s, int k) {
        len = s.length();
        map = new int[len][len];
        memo = new Integer[len][k + 1];
        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len; i++) {
                int j = i + l;
                if (j >= len) {
                    continue;
                }
                if (i == j) {
                    map[i][j] = 0;
                } else if (s.charAt(i) == s.charAt(j)) {
                    map[i][j] = map[i + 1][j - 1];
                } else {
                    map[i][j] = map[i + 1][j - 1] + 1;
                }
            }
        }
        return helper(s, 0, k);
    }

    private int helper(String s, int i, int k) {
        if (i == s.length()) {
            if (k == 0) {
                return 0;
            }
            return 0x3f3f3f3f;
        }
        if (k < 0) {
            return 0x3f3f3f3f;
        }
        if (memo[i][k] != null) {
            return memo[i][k];
        }
        int res = 0x3f3f3f3f;
        for (int j = i; j < len; j++) {
            res = Math.min(res, map[i][j] + helper(s, j + 1, k - 1));
        }
        return memo[i][k] = res;
    }
}
