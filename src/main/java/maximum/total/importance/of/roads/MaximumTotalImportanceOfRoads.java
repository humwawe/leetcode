package maximum.total.importance.of.roads;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumTotalImportanceOfRoads {
  public long maximumImportance(int n, int[][] roads) {
    int[] deg = new int[n];
    for (int[] road : roads) {
      deg[road[0]]++;
      deg[road[1]]++;
    }
    Arrays.sort(deg);
    long res = 0;
    for (int i = 1; i <= n; i++) {
      res += (long) i * deg[i - 1];
    }
    return res;
  }
}
