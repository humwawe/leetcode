package maximum.consecutive.floors.without.special.floors;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumConsecutiveFloorsWithoutSpecialFloors {
  public int maxConsecutive(int bottom, int top, int[] s) {
    Arrays.sort(s);
    int len = s.length;
    int res = 0;
    res = Math.max(s[0] - bottom, res);
    for (int i = 1; i < len; ++i) {
      res = Math.max(s[i] - s[i - 1] - 1, res);
    }
    res = Math.max(res, top - s[len - 1]);
    return res;

  }

}
