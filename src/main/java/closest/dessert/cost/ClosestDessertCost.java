package closest.dessert.cost;

/**
 * @author hum
 */
public class ClosestDessertCost {
    int res = Integer.MAX_VALUE;
    int[] t;
    int target;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        t = toppingCosts;
        for (int base : baseCosts) {
            dfs(0, base);
        }
        return res;
    }

    private void dfs(int pos, int cost) {
        if (Math.abs(target - cost) < Math.abs(target - res) || Math.abs(target - cost) == Math.abs(target - res) && cost < res) {
            res = cost;
        }
        if (cost >= target || pos == t.length) {
            return;
        }
        dfs(pos + 1, cost);
        dfs(pos + 1, cost + t[pos]);
        dfs(pos + 1, cost + 2 * t[pos]);
    }
}
