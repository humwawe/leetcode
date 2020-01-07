package count.different.palindromic.subsequences;

/**
 * @author hum
 */
public class CountDifferentPalindromicSubsequences {
    int[][] memo;
    int mod = 1000000007;

    public int countPalindromicSubsequences(String s) {
        int len = s.length();
        int n = s.length();
        memo = new int[len][len];
        return helper(s.toCharArray(), 0, n - 1);
    }

    private int helper(char[] s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        long ans = 0;
        if (s[i] == s[j]) {
            ans += helper(s, i + 1, j - 1) * 2;
            int l = i + 1;
            int r = j - 1;
            while (l <= r && s[l] != s[i]) {
                ++l;
            }
            while (l <= r && s[r] != s[i]) {
                --r;
            }
            if (l > r) {
                ans += 2;
            } else if (l == r) {
                ans += 1;
            } else {
                ans -= helper(s, l + 1, r - 1);
            }
        } else {
            ans = helper(s, i, j - 1) + helper(s, i + 1, j) - helper(s, i + 1, j - 1);
        }

        memo[i][j] = (int) ((ans + mod) % mod);
        return memo[i][j];
    }
}
