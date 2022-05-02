package k.divisible.elements.subarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class KDivisibleElementsSubarrays {
  public int countDistinct(int[] nums, int k, int p) {
    Set<String> res = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      int cnt = 0;
      StringBuilder sb = new StringBuilder();
      for (int j = i; j < nums.length; j++) {
        sb.append(nums[j]).append("|");
        if (nums[j] % p == 0) {
          cnt++;
        }
        if (cnt > k) {
          break;
        }
        res.add(sb.toString());
      }
    }
    return res.size();
  }
}
