package minimum.insertion.steps.to.make.a.string.palindrome;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return len - dp[len][len];
    }
}
