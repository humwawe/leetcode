package palindromic.substrings;

/**
 * @author hum
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int result = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            result++;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                result++;
            }
        }
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i + l <= len; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
