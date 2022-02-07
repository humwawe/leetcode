package keep.multiplying.found.values.by.two;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class KeepMultiplyingFoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (true) {
            if (set.contains(original)) {
                original *= 2;
            } else {
                break;
            }
        }
        return original;
    }
}
