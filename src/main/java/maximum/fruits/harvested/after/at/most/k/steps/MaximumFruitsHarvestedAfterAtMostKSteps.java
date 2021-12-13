package maximum.fruits.harvested.after.at.most.k.steps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MaximumFruitsHarvestedAfterAtMostKSteps {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] fruit : fruits) {
            map.put(fruit[0], fruit[1]);
        }
        int N = (int) (2e5 + 5);
        int[] sum = new int[N];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + map.getOrDefault(i - 1, 0);
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            int r = startPos + i;
            int l = startPos - (k - i * 2);
            if (l < startPos) {
                res = Math.max(res, sum[Math.min(r + 1, N - 1)] - sum[startPos] + sum[startPos] - sum[Math.max(0, l)]);
            } else {
                res = Math.max(res, sum[Math.min(r + 1, N - 1)] - sum[startPos]);
            }
        }
        for (int i = 0; i <= k; i++) {
            int l = startPos - i;
            int r = startPos + (k - 2 * i);
            if (r > startPos) {
                res = Math.max(res, sum[Math.min(r + 1, N - 1)] - sum[startPos + 1] + sum[startPos + 1] - sum[Math.max(0, l)]);
            } else {
                res = Math.max(res, sum[startPos + 1] - sum[Math.max(0, l)]);
            }
        }
        return res;

    }
}
