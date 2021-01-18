package tuple.with.same.product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class TupleWithSameProduct {
    public int tupleSameProduct(int[] nums) {
        int len = nums.length, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int mul = nums[i] * nums[j];
                map.put(mul, map.getOrDefault(mul, 0) + 1);
            }
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val >= 2) {
                res += (val * (val - 1)) / 2 * 8;
            }
        }
        return res;
    }
}
