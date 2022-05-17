package number.of.ways.to.split.array;

/**
 * @author hum
 */
public class NumberOfWaysToSplitArray {
  public int waysToSplitArray(int[] nums) {
    long sum = 0;
    for (int num : nums) {
      sum += num;
    }
    int res = 0;
    long tmp = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      tmp += nums[i];
      if (tmp >= sum - tmp) {
        res++;
      }
    }
    return res;
  }
}
