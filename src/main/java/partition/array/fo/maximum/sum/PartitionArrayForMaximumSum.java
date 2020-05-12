package partition.array.fo.maximum.sum;

/**
 * @author hum
 */
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int len = a.length;
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int max = 0;
            for (int j = i; i - j + 1 <= k && j > 0; j--) {
                max = Math.max(max, a[j - 1]);
                dp[i] = Math.max(dp[i], dp[j - 1] + (i - j + 1) * max);
            }
        }
        return dp[len];
    }
}
