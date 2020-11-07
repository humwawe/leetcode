package count.sorted.vowel.strings;

/**
 * @author hum
 */
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += dp[n][i];
        }
        return sum;
    }
}
