package query.kth.smallest.trimmed.number;

import java.util.Arrays;

/**
 * @author hum
 */
public class QueryKthSmallestTrimmedNumber {
  public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    int len = queries.length;
    int n = nums[0].length();
    int[] res = new int[len];
    Integer[] idx = new Integer[nums.length];
    for (int i = 0; i < nums.length; i++) {
      idx[i] = i;
    }
    for (int i = 0; i < len; i++) {
      int k = queries[i][0] - 1;
      int t = queries[i][1];
      Arrays.sort(idx, (x, y) -> {
        int d = nums[x].substring(n - t).compareTo(nums[y].substring(n - t));
        if (d == 0) {
          return x - y;
        }
        return d;
      });
      res[i] = idx[k];
    }
    return res;
  }
}
