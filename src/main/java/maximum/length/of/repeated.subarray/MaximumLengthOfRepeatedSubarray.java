package maximum.length.of.repeated.subarray;

/**
 * @author hum
 */
public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] a, int[] b) {
        int result = 0;
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
