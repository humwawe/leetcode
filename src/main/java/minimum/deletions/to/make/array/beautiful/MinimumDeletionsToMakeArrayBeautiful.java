package minimum.deletions.to.make.array.beautiful;

/**
 * @author hum
 */
public class MinimumDeletionsToMakeArrayBeautiful {
  public int minDeletion(int[] nums) {
    int len = nums.length;
    int res = 0;
    for (int i = 0; i < len; ) {
      int j = i;
      while (j + 1 < len && nums[j + 1] == nums[i]) {
        j++;
      }
      res += j - i;
      i = j + 2;
    }
    if ((len - res) % 2 != 0) {
      res++;
    }
    return res;
  }
}
