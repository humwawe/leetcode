package longest.subsequence.with.limited.sum;

import java.util.Arrays;

/**
 * @author hum
 */
public class LongestSubsequenceWithLimitedSum {
  public int[] answerQueries(int[] nums, int[] queries) {
    int n = nums.length;
    int m = queries.length;
    Arrays.sort(nums);
    for (int i = 1; i < n; i++) {
      nums[i] += nums[i - 1];
    }

    int[] res = new int[m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (nums[j] <= queries[i]) {
          res[i] = j + 1;
        }
      }
    }
    return res;
  }

}
