package minimum.cost.fo.tickets;

/**
 * @author hum
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        boolean[] map = new boolean[366];
        for (int day : days) {
            map[day] = true;
        }
        for (int i = 1; i <= 365; i++) {
            if (!map[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + costs[0];
            if (i >= 7) {
                dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
            } else {
                dp[i] = Math.min(dp[i], dp[0] + costs[1]);
            }
            if (i >= 30) {
                dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
            } else {
                dp[i] = Math.min(dp[i], dp[0] + costs[2]);
            }
        }
        return dp[365];
    }
}
