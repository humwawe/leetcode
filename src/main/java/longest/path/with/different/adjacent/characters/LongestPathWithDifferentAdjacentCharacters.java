package longest.path.with.different.adjacent.characters;

import java.util.Arrays;

/**
 * @author hum
 */
public class LongestPathWithDifferentAdjacentCharacters {
  int N = 100010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int[] parent;
  String s;
  int[] d = new int[N];

  int res = 0;

  public int longestPath(int[] parent, String s) {
    Arrays.fill(h, -1);
    idx = 0;
    this.s = s;
    this.parent = parent;
    for (int i = 1; i < parent.length; i++) {
      add(i, parent[i]);
      add(parent[i], i);
    }

    dfs(0, 0);
    return res;
  }

  private void dfs(int u, int p) {
    int max1 = 0;
    int max2 = 0;
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      if (s.charAt(j) != s.charAt(u)) {
        if (d[j] > max1) {
          max2 = max1;
          max1 = d[j];
        } else if (d[j] > max2) {
          max2 = d[j];
        }
      }
    }
    d[u] = max1 + 1;
    res = Math.max(res, max1 + max2 + 1);
  }


  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
