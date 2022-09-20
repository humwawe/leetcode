package smallest.subarrays.with.maximum.bitwise.or;

import java.util.Arrays;

/**
 * @author hum
 */
public class SmallestSubarraysWithMaximumBitwiseOr {
  public int[] smallestSubarrays(int[] nums) {
    int[] pos = new int[31];
    Arrays.fill(pos, -1);
    int n = nums.length;
    int[] res = new int[n];

    for (int i = n - 1; i >= 0; i--) {

      for (int j = 0; j < 31; j++) {
        if ((nums[i] >> j & 1) == 1) {
          pos[j] = i;
        }
      }
      int max = i;

      for (int j = 30; j >= 0; j--) {
        if (pos[j] == -1) {
          continue;
        }
        max = Math.max(max, pos[j]);
      }
      res[i] = max - i + 1;
    }
    return res;
  }
}
