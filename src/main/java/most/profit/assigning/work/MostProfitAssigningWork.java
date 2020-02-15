package most.profit.assigning.work;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
        }
        int[] dp = new int[10001];
        for (int i = 1; i < 10001; i++) {
            dp[i] = Math.max(dp[i - 1], map.getOrDefault(i, 0));
        }
        int result = 0;
        for (int i : worker) {
            result += dp[i];
        }
        return result;
    }
}
