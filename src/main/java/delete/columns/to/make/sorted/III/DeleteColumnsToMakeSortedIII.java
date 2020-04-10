package delete.columns.to.make.sorted.III;

/**
 * @author hum
 */
public class DeleteColumnsToMakeSortedIII {
    public int minDeletionSize(String[] a) {
        int n = a[0].length();
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            search:
            for (int j = 0; j < i; j++) {
                for (String s : a) {
                    if (s.charAt(j) > s.charAt(i)) {
                        continue search;
                    }
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
                res = Math.max(res, dp[i]);
            }
        }
        return n - res;
    }
}
