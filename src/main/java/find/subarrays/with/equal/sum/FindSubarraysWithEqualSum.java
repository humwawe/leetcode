package find.subarrays.with.equal.sum;

/**
 * @author hum
 */
public class FindSubarraysWithEqualSum {
  public boolean findSubarrays(int[] nums) {
    int len = nums.length;
    for (int i = 0; i + 1 < len; i++) {
      int sum = nums[i] + nums[i + 1];
      for (int j = i + 1; j + 1 < len; j++) {
        if (sum == nums[j] + nums[j + 1]) {
          return true;
        }
      }
    }
    return false;
  }
}
