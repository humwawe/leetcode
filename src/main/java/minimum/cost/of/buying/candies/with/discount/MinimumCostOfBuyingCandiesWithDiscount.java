package minimum.cost.of.buying.candies.with.discount;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumCostOfBuyingCandiesWithDiscount {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        for (int i : cost) {
            sum += i;
        }
        for (int i = cost.length - 3; i >= 0; i -= 3) {
            sum -= cost[i];
        }
        return sum;
    }
}
