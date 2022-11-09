package minimum.total.distance.traveled;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class MinimumTotalDistanceTraveled {
  public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
    Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
    Collections.sort(robot);
    int m = robot.size();
    long[] f = new long[m + 1];
    Arrays.fill(f, (long) 1e18);
    f[0] = 0;
    for (int[] fa : factory) {
      for (int j = m; j > 0; j--) {
        long cost = 0L;
        for (int k = 1; k <= Math.min(j, fa[1]); ++k) {
          cost += Math.abs(robot.get(j - k) - fa[0]);
          f[j] = Math.min(f[j], f[j - k] + cost);
        }
      }
    }
    return f[m];
  }
}
