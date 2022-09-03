package build.a.matrix.with.conditions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class BuildAMatrixWithConditions {
  int N = 405;
  int M = (int) (1e4 + 5);
  int[] h = new int[N];
  int[] e = new int[M];
  int[] ne = new int[M];
  int idx = 0;
  int[] deg = new int[410];
  int n;


  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    this.n = k;

    Arrays.fill(h, -1);
    Arrays.fill(deg, 0);
    idx = 0;
    for (int[] row : rowConditions) {
      add(row[0], row[1]);
      deg[row[1]]++;
    }
    int[] pos1 = new int[k + 1];
    boolean f = top(pos1);
    if (!f) {
      return new int[][]{};
    }


    Arrays.fill(h, -1);
    Arrays.fill(deg, 0);
    idx = 0;
    for (int[] col : colConditions) {
      add(col[0], col[1]);
      deg[col[1]]++;
    }

    int[] pos2 = new int[k + 1];
    f = top(pos2);
    if (!f) {
      return new int[][]{};
    }
    int[][] res = new int[k][k];
    for (int i = 1; i <= n; i++) {
      res[pos1[i]][pos2[i]] = i;
    }
    return res;
  }

  private boolean top(int[] pos) {
    int idx = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      if (deg[i] == 0) {
        queue.add(i);
        pos[i] = idx++;
      }
    }
    while (!queue.isEmpty()) {
      Integer u = queue.poll();
      for (int i = h[u]; i != -1; i = ne[i]) {
        int j = e[i];
        if (--deg[j] == 0) {
          queue.add(j);
          pos[j] = idx++;
        }
      }
    }
    return idx == n;
  }


  void add(int a, int b) {
    e[idx] = b;
    ne[idx] = h[a];
    h[a] = idx++;
  }
}
