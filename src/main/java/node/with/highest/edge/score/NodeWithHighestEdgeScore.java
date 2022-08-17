package node.with.highest.edge.score;

/**
 * @author hum
 */
public class NodeWithHighestEdgeScore {
  public int edgeScore(int[] edges) {
    int n = edges.length;
    long[] cnt = new long[n];
    for (int x = 0; x < n; x++) {
      int y = edges[x];
      cnt[y] += x;
    }

    int res = 0;
    for (int x = 0; x < n; x++) {
      if (cnt[x] > cnt[res]) {
        res = x;
      }
    }
    return res;
  }

}
