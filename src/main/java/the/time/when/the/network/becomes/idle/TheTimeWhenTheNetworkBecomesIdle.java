package the.time.when.the.network.becomes.idle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class TheTimeWhenTheNetworkBecomesIdle {
    int N = 100010;
    int M = N * 2;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    int[] dist = new int[N];

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        Arrays.fill(h, -1);
        idx = 0;
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }
        bfs(0);
        int res = 0;
        for (int i = 1; i < patience.length; i++) {
            int cnt = (2 * dist[i] - 1) / patience[i] * patience[i];
            res = Math.max(res, cnt + 2 * dist[i]);
        }
        return res + 1;
    }

    void bfs(int u) {
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(u);
        dist[u] = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = h[x]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] == -1) {
                    dist[j] = dist[x] + 1;
                    queue.add(j);
                }
            }
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
