package count.unreachable.pairs.of.nodes.in.an.undirected.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
  public long countPairs(int n, int[][] edges) {
    List<Integer>[] list = new List[n];
    for (int i = 0; i < n; i++) {
      list[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      list[edge[0]].add(edge[1]);
      list[edge[1]].add(edge[0]);
    }
    boolean[] vis = new boolean[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      long count = dfs(i, vis, list);
      sum += count * (n - count);
    }
    return sum / 2;
  }

  private long dfs(int i, boolean[] visited, List<Integer>[] list) {
    if (visited[i]) {
      return 0;
    }
    visited[i] = true;
    int count = 1;
    for (int j : list[i]) {
      count += dfs(j, visited, list);
    }
    return count;
  }
}
