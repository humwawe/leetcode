package degree.of.an.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0) + 1;
            max = Math.max(max, count);
            map.put(nums[i], count);
            if (count == 1) {
                map1.put(nums[i], i);
            }
            map2.put(nums[i], i);
        }
        int result = 50001;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == max) {
                result = Math.min(result, map2.get(integer) - map1.get(integer) + 1);
                if (result == max) {
                    return result;
                }
            }
        }
        return result;
    }
}
