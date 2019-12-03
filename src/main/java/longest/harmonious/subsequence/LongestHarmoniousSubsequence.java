package longest.harmonious.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class LongestHarmoniousSubsequence {
    public int findLhs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (Integer integer : map.keySet()) {
            if (map.containsKey(integer + 1)) {
                result = Math.max(result, map.get(integer) + map.get(integer + 1));
            }
        }
        return result;
    }
}
