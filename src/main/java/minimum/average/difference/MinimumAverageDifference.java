package minimum.average.difference;

/**
 * @author hum
 */
public class MinimumAverageDifference {
  public int minimumAverageDifference(int[] nums) {
    int len = nums.length;
    long[] sum = new long[len + 1];
    for (int i = 0; i < len; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
    long res = (long) 1e12;
    int idx = 0;
    for (int i = 0; i < len; i++) {
      long prev = sum[i + 1];
      long last = sum[len] - sum[i + 1];
      if (i == len - 1) {
        if (res > Math.abs(prev / (i + 1))) {
          res = Math.abs(prev / (i + 1));
          idx = len - 1;
        }
      } else {
        if (res > Math.abs(prev / (i + 1) - last / (len - i - 1))) {
          res = Math.abs(prev / (i + 1) - last / (len - i - 1));
          idx = i;
        }
      }
    }
    return idx;
  }
}
