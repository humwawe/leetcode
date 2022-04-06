package find.triangular.sum.of.an.array;

/**
 * @author hum
 */
public class FindTriangularSumOfAnArray {
  public int triangularSum(int[] nums) {
    int len = nums.length;
    for (int i = len - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        nums[j] = (nums[j] + nums[j + 1]) % 10;
      }
    }

    return nums[0];
  }
}
