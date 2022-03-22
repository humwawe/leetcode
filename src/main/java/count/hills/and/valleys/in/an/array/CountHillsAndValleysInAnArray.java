package count.hills.and.valleys.in.an.array;

/**
 * @author hum
 */
public class CountHillsAndValleysInAnArray {
  public int countHillValley(int[] nums) {
    int res = 0;
    int len = nums.length;
    for (int i = 1; i < len - 1; ) {
      int l = i - 1, r = i + 1;
      while (l >= 0 && nums[i] == nums[l]) {
        l--;
      }
      while (r < len && nums[i] == nums[r]) {
        r++;
      }
      if (l >= 0 && r < len) {
        if (nums[i] < nums[l] && nums[i] < nums[r]) {
          res++;
        }
        if (nums[i] > nums[l] && nums[i] > nums[r]) {
          res++;
        }
      }
      i = r;
    }

    return res;
  }

}
