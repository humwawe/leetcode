package make.array.zero.by.subtracting.equal.amounts;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class MakeArrayZeroBySubtractingEqualAmounts {
  public int minimumOperations(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (num != 0) {
        set.add(num);
      }
    }
    return set.size();
  }

}
