package soup.servings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class SoupServings {
    Map<String, Double> memo = new HashMap<>();

    public double soupServings(int n) {
        if (n > 5000) {
            return 1;
        }
        return helper(n, n);
    }

    private double helper(int a, int b) {
        if (a <= 0 && b > 0) {
            return 1;
        }
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a > 0 && b <= 0) {
            return 0;
        }
        String tmp = a + "#" + b;
        if (memo.containsKey(tmp)) {
            return memo.get(tmp);
        }
        double res = 0.25 * (helper(a - 100, b) + helper(a - 50, b - 50) + helper(a - 75, b - 25) + helper(a - 25, b - 75));
        memo.put(tmp, res);
        return res;
    }
}
