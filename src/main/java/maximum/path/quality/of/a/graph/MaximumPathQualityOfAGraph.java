package maximum.path.quality.of.a.graph;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumPathQualityOfAGraph {
    int N = 1010;
    int M = N * 8;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int[] w = new int[M];
    int idx;
    int[] values;
    int[] vis = new int[N];
    int res = 0;
    int v = 0;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        Arrays.fill(h, -1);
        idx = 0;
        for (int[] edge : edges) {
            add(edge[0], edge[1], edge[2]);
            add(edge[1], edge[0], edge[2]);
        }
        dfs(0, maxTime);
        return res;
    }

    private void dfs(int u, int val) {
        vis[u]++;
        if (vis[u] == 1) {
            v += values[u];
        }
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (val >= w[i]) {
                dfs(j, val - w[i]);
            }
        }
        if (u == 0) {
            res = Math.max(res, v);
        }
        vis[u]--;
        if (vis[u] == 0) {
            v -= values[u];
        }
    }

    void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
