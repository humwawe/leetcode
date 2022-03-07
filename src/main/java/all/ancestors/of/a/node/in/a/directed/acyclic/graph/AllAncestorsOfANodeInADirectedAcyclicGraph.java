package all.ancestors.of.a.node.in.a.directed.acyclic.graph;

import java.util.*;

/**
 * @author hum
 */
public class AllAncestorsOfANodeInADirectedAcyclicGraph {
  int N = 1010;
  int M = N * N;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int n;
  int[] deg = new int[N];

  public List<List<Integer>> getAncestors(int n, int[][] edges) {
    Arrays.fill(h, -1);
    idx = 0;
    this.n = n;
    List<Set<Integer>> res = new ArrayList<>();
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      res.add(new HashSet<>());
      ret.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      deg[edge[1]]++;
      add(edge[0], edge[1]);
    }
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (deg[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      for (int i = h[cur]; i != -1; i = ne[i]) {
        int j = e[i];
        deg[j]--;
        if (deg[j] == 0) {
          queue.add(j);
        }
        res.get(j).add(cur);
        res.get(j).addAll(res.get(cur));
      }
    }

    for (int i = 0; i < res.size(); i++) {
      ret.get(i).addAll(res.get(i));
      Collections.sort(ret.get(i));
    }
    return ret;
  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
