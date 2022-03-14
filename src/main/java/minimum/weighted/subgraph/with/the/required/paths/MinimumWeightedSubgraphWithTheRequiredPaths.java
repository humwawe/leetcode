package minimum.weighted.subgraph.with.the.required.paths;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MinimumWeightedSubgraphWithTheRequiredPaths {
  int N = 100005;
  int M = N;
  boolean[] vis = new boolean[N];
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int[] w = new int[M];
  int idx;

  int[] hf = new int[N];
  int[] ef = new int[M];
  int[] nef = new int[M];
  int[] wf = new int[M];
  int idxf;

  int n;
  long inf = (long) 1e12;

  public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
    Arrays.fill(h, -1);
    Arrays.fill(hf, -1);
    idxf = 0;
    idx = 0;
    this.n = n;
    for (int[] edge : edges) {
      add(edge[0], edge[1], edge[2]);
      addf(edge[1], edge[0], edge[2]);
    }
    long[] dist1 = dijkstra(src1);
    long[] dist2 = dijkstra(src2);
    long[] dist3 = dijkstraf(dest);

    long res = inf;
    for (int i = 0; i < n; i++) {
      res = Math.min(res, dist1[i] + dist2[i] + dist3[i]);
    }
    return res == inf ? -1 : res;
  }

  long[] dijkstra(int start) {
    long[] dist = new long[N];
    Arrays.fill(dist, (long) 1e12);
    Arrays.fill(vis, false);
    dist[start] = 0;
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new long[]{0, start});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int v = (int) poll[1];
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = h[v]; i != -1; i = ne[i]) {
        int j = e[i];
        if (dist[j] > d + w[i]) {
          dist[j] = d + w[i];
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
    }

    return dist;
  }

  long[] dijkstraf(int start) {
    long[] dist = new long[N];
    Arrays.fill(dist, (long) 1e12);
    Arrays.fill(vis, false);
    dist[start] = 0;
    PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
    priorityQueue.add(new long[]{0, start});
    while (!priorityQueue.isEmpty()) {
      long[] poll = priorityQueue.poll();
      long d = poll[0];
      int v = (int) poll[1];
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      for (int i = hf[v]; i != -1; i = nef[i]) {
        int j = ef[i];
        if (dist[j] > d + wf[i]) {
          dist[j] = d + wf[i];
          priorityQueue.add(new long[]{dist[j], j});
        }
      }
    }

    return dist;
  }

  void add(int a, int b, int v) {
    e[idx] = b;
    w[idx] = v;
    ne[idx] = h[a];
    h[a] = idx++;
  }

  void addf(int a, int b, int v) {
    ef[idxf] = b;
    wf[idxf] = v;
    nef[idxf] = hf[a];
    hf[a] = idxf++;
  }
}
