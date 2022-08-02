package find.closest.node.to.given.two.nodes;

import java.util.Arrays;

/**
 * @author hum
 */
public class FindClosestNodeToGivenTwoNodes {
  public int closestMeetingNode(int[] edges, int node1, int node2) {
    int n = edges.length;
    int[] dist1 = new int[n];
    Arrays.fill(dist1, -1);
    dist1[node1] = 0;
    int t = node1;
    while (true) {
      int x = edges[t];
      if (x == -1 || dist1[x] != -1) {
        break;
      }
      dist1[x] = dist1[t] + 1;
      t = x;
    }

    int[] dist2 = new int[n];
    Arrays.fill(dist2, -1);
    dist2[node2] = 0;
    t = node2;
    while (true) {
      int x = edges[t];
      if (x == -1 || dist2[x] != -1) {
        break;
      }
      dist2[x] = dist2[t] + 1;
      t = x;
    }
    int min = (int) 1e8;
    int res = -1;
    for (int i = 0; i < n; i++) {
      if (dist1[i] != -1 && dist2[i] != -1) {
        if (min > Math.max(dist1[i], dist2[i])) {
          min = Math.max(dist1[i], dist2[i]);
          res = i;
        }
      }
    }
    return res;
  }
}
