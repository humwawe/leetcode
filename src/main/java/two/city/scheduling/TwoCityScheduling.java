package two.city.scheduling;

import java.util.Arrays;

/**
 * @author hum
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int result = 0;
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            result += costs[i][0] + costs[i + n][1];
        }
        return result;
    }
}
