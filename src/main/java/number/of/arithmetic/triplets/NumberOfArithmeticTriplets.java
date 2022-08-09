package number.of.arithmetic.triplets;

/**
 * @author hum
 */
public class NumberOfArithmeticTriplets {
  public int arithmeticTriplets(int[] nums, int diff) {
    int len = nums.length;
    int res = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        for (int k = j + 1; k < len; k++) {
          if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
            res++;
          }
        }
      }
    }
    return res;

  }
}
