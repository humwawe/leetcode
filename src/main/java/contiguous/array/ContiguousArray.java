package contiguous.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return result;
    }
}
