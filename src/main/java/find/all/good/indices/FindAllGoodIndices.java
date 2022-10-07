package find.all.good.indices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class FindAllGoodIndices {
  public List<Integer> goodIndices(int[] nums, int k) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(left, 1);
    Arrays.fill(right, 1);
    for (int i = 1; i < n; i++) {
      if (nums[i] <= nums[i - 1]) {
        left[i] = left[i - 1] + 1;
      }
      if (nums[n - i - 1] <= nums[n - i]) {
        right[n - i - 1] = right[n - i] + 1;
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = k; i < n - k; i++) {
      if (left[i - 1] >= k && right[i + 1] >= k) {
        ans.add(i);
      }
    }
    return ans;
  }

}
