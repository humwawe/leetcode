package min.max.game;

/**
 * @author hum
 */
public class MinMaxGame {
  public int minMaxGame(int[] nums) {
    int len = nums.length;
    int idx = 0;
    while (len != 1) {
      for (int i = 0; i < len; i++) {
        if ((idx & 1) == 1) {
          nums[idx++] = Math.max(nums[i], nums[++i]);
        } else {
          nums[idx++] = Math.min(nums[i], nums[++i]);
        }
      }
      len >>= 1;
      idx = 0;
    }
    return nums[idx];
  }
}
