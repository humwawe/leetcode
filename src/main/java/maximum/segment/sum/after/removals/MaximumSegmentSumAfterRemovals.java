package maximum.segment.sum.after.removals;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author hum
 */
public class MaximumSegmentSumAfterRemovals {
  public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
    int n = nums.length;
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
    TreeSet<Node> set = new TreeSet<>(Comparator.comparingInt(x -> x.l));
    long[] res = new long[n];
    long max = 0;

    for (int i = n - 1; i >= 0; i--) {
      res[i] = max;
      int t = removeQueries[i];
      int prev = t;
      int next = t;
      Node tmp = new Node(t - 1, t - 1);

      Node floor = set.floor(tmp);
      if (floor != null && floor.r == t - 1) {
        prev = floor.l;
        set.remove(floor);
      }
      tmp = new Node(t + 1, t + 1);
      Node ceiling = set.ceiling(tmp);
      if (ceiling != null && ceiling.l == t + 1) {
        next = ceiling.r;
        set.remove(ceiling);
      }
      max = Math.max(max, sum[next + 1] - sum[prev]);
      set.add(new Node(prev, next));

    }
    return res;
  }

  class Node {
    int l;
    int r;

    public Node(int l, int r) {
      this.l = l;
      this.r = r;
    }
  }
}
