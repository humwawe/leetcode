package find.closest.number.to.zero;

/**
 * @author hum
 */
public class FindClosestNumberToZero {
  public int findClosestNumber(int[] nums) {
    int ans = nums[0];
    for (int x : nums) {
      if (Math.abs(x) < Math.abs(ans)) {
        ans = x;
      } else if (Math.abs(x) == Math.abs(ans)) {
        ans = Math.max(ans, x);
      }
    }
    return ans;
  }
}
