package maximum.ice.cream.bars;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int len = costs.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += costs[i];
            if (sum > coins) {
                return i;
            }
        }
        return len;
    }
}
