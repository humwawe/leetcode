package reachable.nodes.with.restrictions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class ReachableNodesWithRestrictions {
  int N = (int) (1e5 + 5);
  int M = 2 * N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  Set<Integer> set = new HashSet<>();

  public int reachableNodes(int n, int[][] edges, int[] restricted) {
    this.n = n;
    for (int i = 0; i < n; i++) {
      h[i] = -1;
    }
    idx = 0;
    for (int[] edge : edges) {
      add(edge[0], edge[1]);
      add(edge[1], edge[0]);
    }
    for (int i : restricted) {
      set.add(i);
    }
    return dfs(0, 0);
  }

  private int dfs(int u, int p) {
    if (set.contains(u)) {
      return 0;
    }
    int t = 1;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      t += dfs(j, u);
    }
    return t;
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
