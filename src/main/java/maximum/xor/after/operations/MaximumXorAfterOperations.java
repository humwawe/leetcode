package maximum.xor.after.operations;

/**
 * @author hum
 */
public class MaximumXorAfterOperations {
  public int maximumXOR(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res |= num;
    }
    return res;
  }
}
