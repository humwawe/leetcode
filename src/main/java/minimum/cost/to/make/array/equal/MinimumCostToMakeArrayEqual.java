package minimum.cost.to.make.array.equal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MinimumCostToMakeArrayEqual {
  public long minCost(int[] nums, int[] cost) {
    int n = nums.length;
    long res = 0;
    int[][] arr = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr[i][0] = nums[i];
      arr[i][1] = cost[i];
    }
    Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += cost[i];
    }
    long mid = sum / 2;
    long s = 0;
    for (int i = 0; i < n; i++) {
      s += arr[i][1];
      if (s > mid) {
        mid = arr[i][0];
        break;
      }
    }
    for (int i = 0; i < n; i++) {
      res += Math.abs(arr[i][0] - mid) * arr[i][1];
    }
    return res;
  }
}
