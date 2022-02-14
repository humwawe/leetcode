package minimum.operations.to.make.the.array.alternating;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MinimumOperationsToMakeTheArrayAlternating {
    public int minimumOperations(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < len; i += 2) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < len; i += 2) {
            map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
        }

        int maxA1 = 0;
        int k1 = 0;
        int maxA2 = 0;
        for (Map.Entry<Integer, Integer> kv : map1.entrySet()) {
            if (kv.getValue() >= maxA1) {
                maxA2 = maxA1;
                maxA1 = kv.getValue();
                k1 = kv.getKey();
            } else if (kv.getValue() > maxA2) {
                maxA2 = kv.getValue();
            }
        }

        int maxB1 = 0;
        int k2 = 0;
        int maxB2 = 0;
        for (Map.Entry<Integer, Integer> kv : map2.entrySet()) {
            if (kv.getValue() >= maxB1) {
                maxB2 = maxB1;
                maxB1 = kv.getValue();
                k2 = kv.getKey();
            } else if (kv.getValue() > maxB2) {
                maxB2 = kv.getValue();
            }
        }

        if (k1 != k2) {
            return len - (maxA1 + maxB1);
        }

        return len - (Math.max(maxA1 + maxB2, maxA2 + maxB1));
    }
}
