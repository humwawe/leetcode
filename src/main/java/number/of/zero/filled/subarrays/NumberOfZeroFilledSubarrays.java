package number.of.zero.filled.subarrays;

/**
 * @author hum
 */
public class NumberOfZeroFilledSubarrays {
  public long zeroFilledSubarray(int[] nums) {
    long ans = 0L;
    int c = 0;
    for (int num : nums) {
      if (num != 0) {
        c = 0;
      } else {
        ans += ++c;
      }
    }
    return ans;
  }

}
