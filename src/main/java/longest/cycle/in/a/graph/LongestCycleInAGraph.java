package longest.cycle.in.a.graph;

/**
 * @author hum
 */
public class LongestCycleInAGraph {
  public int longestCycle(int[] edges) {

    int res = -1;
    int n = edges.length;
    int[] times = new int[n];
    for (int i = 0, clock = 1; i < n; i++) {
      if (times[i] > 0) {
        continue;
      }
      int start = clock;
      for (int x = i; x != -1; x = edges[x]) {
        if (times[x] > 0) {
          if (times[x] >= start) {
            res = Math.max(res, clock - times[x]);
          }
          break;
        }
        times[x] = clock++;
      }
    }
    return res;
  }
}
