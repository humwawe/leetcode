package longest.well.performing.interval;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int len = hours.length;
        for (int i = 0; i < len; i++) {
            if (hours[i] > 8) {
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
        }
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + hours[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int result = 0;
        for (int i = 1; i <= len; i++) {
            int a = sum[i];
            if (a > 0) {
                result = Math.max(result, i);
            } else if (map.containsKey(a - 1)) {
                result = Math.max(result, i - map.get(a - 1));
            }
            if (!map.containsKey(a)) {
                map.put(a, i);
            }
        }
        return result;
    }

}
