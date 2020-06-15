package divide.array.in.sets.of.k.consecutive.numbers;

import java.util.TreeMap;

/**
 * @author hum
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            Integer integer = map.firstKey();
            for (int i = 0; i < k; i++) {
                if (!map.containsKey(integer + i)) {
                    return false;
                }
                map.put(integer + i, map.get(integer + i) - 1);
                if (map.get(integer + i) == 0) {
                    map.remove(integer + i);
                }
            }
        }
        return true;
    }
}
