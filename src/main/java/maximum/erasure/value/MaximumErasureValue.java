package maximum.erasure.value;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (map.containsKey(nums[i])) {
                sum -= nums[j];
                map.remove(nums[j]);
                j++;
            }
            res = Math.max(res, sum);
            map.put(nums[i], i);
        }
        return res;
    }
}
