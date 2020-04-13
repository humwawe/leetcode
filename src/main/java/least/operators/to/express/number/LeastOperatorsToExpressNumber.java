package least.operators.to.express.number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class LeastOperatorsToExpressNumber {
    Map<String, Integer> memo = new HashMap<>();

    public int leastOpsExpressTarget(int x, int target) {
        int n = (int) (Math.log(target) / Math.log(x)) + 1;
        return helper(x, target, n);
    }

    private int helper(int x, int target, int n) {
        if (n == 0) {
            return target * 2;
        }
        String tmp = target + "#" + n;
        if (memo.containsKey(tmp)) {
            return memo.get(tmp);
        }
        int xn = (int) Math.pow(x, n);
        int k = target / xn;
        int res1 = helper(x, target - k * xn, n - 1) + k * n;
        int res2 = helper(x, Math.abs(target - (k + 1) * xn), n - 1) + (k + 1) * n;
        memo.put(tmp, Math.min(res1, res2));
        return memo.get(tmp);
    }
}
