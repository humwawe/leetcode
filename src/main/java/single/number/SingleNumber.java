package single.number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.remove(nums[i])) {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }
}
