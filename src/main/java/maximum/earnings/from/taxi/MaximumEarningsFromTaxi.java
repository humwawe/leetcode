package maximum.earnings.from.taxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class MaximumEarningsFromTaxi {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int len = rides.length;
        long[] dp = new long[len + 1];
        Arrays.sort(rides, Comparator.comparingInt(x -> x[1]));
        List<Integer> list = new ArrayList<>(len + 1);
        list.add(0);
        for (int[] ride : rides) {
            list.add(ride[1]);
        }
        long res = 0;
        for (int i = 1; i <= len; i++) {
            int start = rides[i - 1][0];
            int end = rides[i - 1][1];
            dp[i] = dp[i - 1];
            int l = 0;
            int r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) <= start) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            dp[i] = Math.max(dp[i], dp[l] + end - start + rides[i - 1][2]);
        }
        return dp[len];
    }
}
