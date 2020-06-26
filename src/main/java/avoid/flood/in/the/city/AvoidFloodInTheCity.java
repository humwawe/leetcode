package avoid.flood.in.the.city;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author hum
 */
public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] result = new int[len];
        Arrays.fill(result, 1);
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            if (rains[i] != 0) {
                result[i] = -1;
                if (map.containsKey(rains[i])) {
                    int start = map.get(rains[i]);
                    Integer ceiling = set.ceiling(start);
                    if (ceiling == null) {
                        return new int[]{};
                    }
                    result[ceiling] = rains[i];
                    set.remove(ceiling);
                }
                map.put(rains[i], i);
            } else {
                set.add(i);
            }
        }
        return result;
    }
}
