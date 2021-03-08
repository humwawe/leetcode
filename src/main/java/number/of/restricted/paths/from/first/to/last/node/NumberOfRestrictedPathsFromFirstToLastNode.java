package number.of.restricted.paths.from.first.to.last.node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class NumberOfRestrictedPathsFromFirstToLastNode {
    int[] h;
    int[] e;
    int[] ne;
    int[] w;
    int idx;
    int[] dist;
    int n;
    int mod = (int) (1e9 + 7);
    Integer[] memo;

    public int countRestrictedPaths(int n, int[][] edges) {
        this.n = n;
        h = new int[n + 1];
        Arrays.fill(h, -1);
        idx = 0;
        int m = edges.length;
        memo = new Integer[n + 1];
        e = new int[m * 2 + 10];
        ne = new int[m * 2 + 10];
        w = new int[m * 2 + 10];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int v = edge[2];
            add(a, b, v);
            add(b, a, v);
        }
        dijkstra();

        return dfs(1);
    }

    private int dfs(int u) {
        if (u == n) {
            return 1;
        }
        if (memo[u] != null) {
            return memo[u];
        }
        long res = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (dist[j] >= dist[u]) {
                continue;
            }
            res += dfs(j);
            res %= mod;
        }
        return memo[u] = (int) (res % mod);
    }

    void dijkstra() {
        dist = new int[n + 1];
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[n] = 0;
        boolean[] vis = new boolean[n + 1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.add(new int[]{0, n});
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            int d = poll[0];
            int v = poll[1];
            if (vis[v]) {
                continue;
            }
            vis[v] = true;
            for (int i = h[v]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > d + w[i]) {
                    dist[j] = d + w[i];
                    priorityQueue.add(new int[]{dist[j], j});
                }
            }
        }
    }

    void add(int a, int b, int v) {
        e[idx] = b;
        w[idx] = v;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
