package minimum.score.after.removals.on.a.tree;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumScoreAfterRemovalsOnATree {
  int N = 1010;
  int M = N * 2;
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx;
  int[] nums;
  int sum = 0;
  boolean[] vis = new boolean[M];
  int[] xor = new int[N];
  int[] xor2 = new int[N];
  int a, b, c;
  int inf = (int) 1e9;
  int ans = inf;

  public int minimumScore(int[] nums, int[][] edges) {
    Arrays.fill(h, -1);
    idx = 0;
    this.nums = nums;
    for (int num : nums) {
      sum ^= num;
    }
    for (int[] edge : edges) {
      add(edge[0], edge[1]);
      add(edge[1], edge[0]);
    }
    dfs(1, 1);

    return ans;
  }

  void dfs(int u, int p) {
    xor[u] = nums[u];
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs(j, u);
      xor[u] ^= xor[j];
      a = xor[j];
      dfs2(u, j);

      a = sum ^ xor[j];
      dfs2(j, u);
    }

  }


  private void helper(int a, int b, int c) {
    int max = Math.max(a, Math.max(b, c));
    int min = Math.min(a, Math.min(b, c));
    ans = Math.min(ans, max - min);
  }

  private void dfs2(int u, int p) {
    xor2[u] = nums[u];
    for (int i = h[u]; i != -1; i = ne[i]) {
      int j = e[i];
      if (j == p) {
        continue;
      }
      dfs2(j, u);

      xor2[u] ^= xor2[j];

      b = xor2[j];
      c = sum ^ a ^ b;
      helper(a, b, c);
    }

  }

  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
