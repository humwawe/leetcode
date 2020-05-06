package longest.arithmetic.sequence;

/**
 * @author hum
 */
public class LongestArithmeticSequence {
    public int longestArithSeqLength(int[] a) {
        int[][] dp = new int[a.length][20001];
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = a[i] - a[j] + 10000;
                if (dp[j][diff] > 0) {
                    dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                } else {
                    dp[i][diff] = 2;
                }
                max = max > dp[i][diff] ? max : dp[i][diff];
            }
        }
        return max;
    }
}
