package minimize.maximum.of.array;

/**
 * @author hum
 */
public class MinimizeMaximumOfArray {
  public int minimizeArrayValue(int[] nums) {
    long max = 0, sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(max, (sum + i) / (i + 1));
    }
    return (int) max;
  }
}
