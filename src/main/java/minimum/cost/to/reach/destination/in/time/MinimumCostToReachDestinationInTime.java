package minimum.cost.to.reach.destination.in.time;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumCostToReachDestinationInTime {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int inf = (int) 1e9;
        int len = passingFees.length;
        int[][] f = new int[maxTime + 1][len];
        for (int i = 0; i < f.length; i++) {
            Arrays.fill(f[i], inf);
        }
        f[0][0] = passingFees[0];
        for (int t = 1; t <= maxTime; ++t) {
            for (int[] edge : edges) {
                int i = edge[0], j = edge[1], cost = edge[2];
                if (cost <= t) {
                    f[t][i] = Math.min(f[t][i], f[t - cost][j] + passingFees[i]);
                    f[t][j] = Math.min(f[t][j], f[t - cost][i] + passingFees[j]);
                }
            }
        }

        int ans = inf;
        for (int t = 1; t <= maxTime; ++t) {
            ans = Math.min(ans, f[t][len - 1]);
        }
        return ans == inf ? -1 : ans;

    }
}
