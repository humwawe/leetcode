package maximum.sum.of.two.non.overlapping.subarrays;

/**
 * @author hum
 */
public class MaximumSumOfTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] a, int l, int m) {
        int len = a.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + a[i];
        }
        int max1 = helper(sum, l, m);
        int max2 = helper(sum, m, l);
        return Math.max(max1, max2);
    }

    private int helper(int[] sum, int l, int m) {
        int len = sum.length;
        int[] dp = new int[len];
        dp[l] = sum[l];
        for (int i = l + 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], sum[i] - sum[i - l]);
        }
        int res = 0;
        int last = 0;
        for (int i = len - 1; i >= l + m; i--) {
            last = Math.max(last, sum[i] - sum[i - m]);
            res = Math.max(res, last + dp[i - m]);
        }
        return res;
    }
}
