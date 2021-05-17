package largest.color.value.in.a.directed.graph;

import java.util.Arrays;

/**
 * @author hum
 */
public class LargestColorValueInADirectedGraph {
    int N = 100010;
    int[] h = new int[N];
    int[] e = new int[N];
    int[] ne = new int[N];
    int idx;
    int n;
    int[] vis;
    String colors;
    int res = 0;
    boolean[] st;
    int[][] cnt = new int[N][26];

    public int largestPathValue(String colors, int[][] edges) {
        this.colors = colors;
        Arrays.fill(h, -1);
        idx = 0;
        n = colors.length();
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
        }
        vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 2) {
                continue;
            }
            if (dfs(i)) {
                return -1;
            }
        }
        System.out.println("ssssss");
        st = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (st[i]) {
                continue;
            }
            dfs2(i);
        }
        return res;
    }

    private int[] dfs2(int u) {
        if (st[u]) {
            return cnt[u];
        }
        st[u] = true;
        int[] tmp = new int[26];
        int t = colors.charAt(u) - 'a';
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            int[] ret = dfs2(j);
            for (int k = 0; k < 26; k++) {
                tmp[k] = Math.max(tmp[k], ret[k]);
                res = Math.max(res, tmp[k]);
            }
        }
        tmp[t] += 1;
        res = Math.max(res, tmp[t]);
        return cnt[u] = tmp;
    }

    private boolean dfs(int u) {
        vis[u] = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (vis[j] == 1) {
                return true;
            } else if (vis[j] == 0) {
                if (dfs(j)) {
                    return true;
                }
            }
        }
        vis[u] = 2;
        return false;
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
