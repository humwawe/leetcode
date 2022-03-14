package maximize.the.topmost.element.after.k.moves;

/**
 * @author hum
 */
public class MaximizeTheTopmostElementAfterKMoves {
  public int maximumTop(int[] nums, int k) {
    int max = 0;
    int len = nums.length;
    if (len == k % 2) {
      return -1;
    }

    for (int i = 0; i < Math.min(k - 1, len); i++) {
      max = Math.max(max, nums[i]);
    }

    return Math.max(max, k < len ? nums[k] : 0);
  }
}
