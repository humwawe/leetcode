package maximum.subarray.sum.with.one.deletion;

/**
 * @author hum
 */
public class MaximumSubarraySumWithOneDeletion {
    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][2];
        dp[0][0] = arr[0];
        int result = arr[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }
        return result;
    }

}
