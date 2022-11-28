package most.profitable.path.in.a.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class MostProfitablePathInATree {
  int[] bobTime;
  int[] amount;
  int res = Integer.MIN_VALUE;

  public int mostProfitablePath(int[][] edges, int bob, int[] amount) {

    int n = amount.length;
    bobTime = new int[n];
    Arrays.fill(bobTime, n);
    this.amount = amount;

    List<Integer>[] g = new List[n];
    for (int i = 0; i < n; ++i) {
      g[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {

      int x = edge[0];
      int y = edge[1];
      g[x].add(y);
      g[y].add(x);
    }

    dfsB(g, bob, -1, 0);
    g[0].add(-1);
    dfsA(g, 0, -1, 0, 0);
    return res;
  }

  public boolean dfsB(List<Integer>[] g, int p, int f, int time) {
    if (p == 0) {
      bobTime[p] = time;
      return true;
    } else {
      boolean flag = false;
      for (int e : g[p]) {
        if (e != f && dfsB(g, e, p, time + 1)) {
          flag = true;
          break;
        }
      }

      if (flag) {
        bobTime[p] = time;
      }
      return flag;
    }
  }

  public void dfsA(List<Integer>[] g, int p, int f, int time, int total) {
    if (bobTime[p] == time) {
      total += amount[p] / 2;
    } else if (bobTime[p] > time) {
      total += amount[p];
    }
    if (g[p].size() == 1) {
      res = Math.max(res, total);
    }
    for (int e : g[p]) {
      if (e != f) {
        dfsA(g, e, p, time + 1, total);
      }
    }
  }
}
