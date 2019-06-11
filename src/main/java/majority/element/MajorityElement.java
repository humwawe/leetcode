package majority.element;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (count < map.get(num)) {
                count = map.get(num);
                result = num;
            }
        }
        return result;
    }
}
