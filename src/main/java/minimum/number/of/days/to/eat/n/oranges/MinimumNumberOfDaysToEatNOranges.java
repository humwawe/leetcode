package minimum.number.of.days.to.eat.n.oranges;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MinimumNumberOfDaysToEatNOranges {
    Map<Integer, Integer> map = new HashMap<>();

    public int minDays(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = Math.min(helper(n / 2) + n % 2 + 1, helper(n / 3) + n % 3 + 1);
        map.put(n, res);
        return res;
    }
}
