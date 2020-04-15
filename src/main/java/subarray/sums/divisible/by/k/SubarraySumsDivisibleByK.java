package subarray.sums.divisible.by.k;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = a.length;
        int[] sum = new int[len];
        sum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sum[i] = sum[i - 1] + a[i];
        }
        int result = 0;
        for (int i : sum) {
            int t = i % k;
            if (t < 0) {
                t += k;
            }
            if (map.containsKey(t)) {
                result += map.get(t);
            }
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return result;
    }
}
