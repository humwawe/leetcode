package second.minimum.time.to.reach.destination;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class SecondMinimumTimeToReachDestination {
    int N = 10010;
    int M = N * 4;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    int[][] dist = new int[N][2];
    int n, time, change;

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        this.n = n;
        this.time = time;
        this.change = change;
        Arrays.fill(h, -1);
        idx = 0;
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }
        return dijkstra(time, change);
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    int dijkstra(int time, int change) {
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 0x3f3f3f3f);
        }
        dist[1][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int d = poll[0];
            int v = poll[1];
            for (int i = h[v]; i != -1; i = ne[i]) {
                int j = e[i];
                int t = next(d);
                if (dist[j][0] > t) {
                    dist[j][0] = t;
                    queue.add(new int[]{dist[j][0], j});
                } else if (dist[j][0] < t && dist[j][1] > t) {
                    dist[j][1] = t;
                    queue.add(new int[]{dist[j][1], j});
                }
            }
        }
        return dist[n][1];
    }

    int next(int d) {
        int t = d;
        if (t / change % 2 == 1) {
            t = (t / change + 1) * change;
        }
        t += time;
        return t;
    }

}
