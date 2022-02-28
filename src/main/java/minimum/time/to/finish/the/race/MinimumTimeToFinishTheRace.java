package minimum.time.to.finish.the.race;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumTimeToFinishTheRace {
  public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
    int[] minSec = new int[18];
    int inf = (int) 1e9;
    Arrays.fill(minSec, inf);
    for (int[] tire : tires) {
      long time = tire[0];
      int sum = 0;
      for (int x = 1; time <= changeTime + tire[0]; ++x) {
        sum += time;
        minSec[x] = Math.min(minSec[x], sum);
        time *= tire[1];
      }
    }

    int[] f = new int[numLaps + 1];
    Arrays.fill(f, inf);
    f[0] = 0;
    for (int i = 1; i <= numLaps; ++i) {
      for (int j = 1; j <= Math.min(17, i); ++j) {
        f[i] = Math.min(f[i], f[i - j] + minSec[j] + changeTime);
      }
    }
    return f[numLaps] - changeTime;
  }

}
