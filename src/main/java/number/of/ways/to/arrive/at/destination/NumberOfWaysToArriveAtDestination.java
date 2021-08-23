package number.of.ways.to.arrive.at.destination;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class NumberOfWaysToArriveAtDestination {
    int N = 205;
    int M = N * N;
    int[] h = new int[N];
    boolean[] vis = new boolean[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int[] w = new int[M];
    int idx;
    long[] dist = new long[N];
    long[] cnt = new long[N];
    int mod = (int) (1e9 + 7);

    public int countPaths(int n, int[][] roads) {
        Arrays.fill(h, -1);
        idx = 0;
        for (int[] road : roads) {
            add(road[0], road[1], road[2]);
            add(road[1], road[0], road[2]);
        }
        dijkstra();
        return (int) cnt[n - 1] % mod;

    }

    void dijkstra() {
        Arrays.fill(dist, 0x3f3f3f3f3f3f3f3fL);
        dist[0] = 0;
        cnt[0] = 1;
        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        priorityQueue.add(new long[]{0, 0});
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
                    cnt[j] = cnt[v];
                    priorityQueue.add(new long[]{dist[j], j});
                } else if (dist[j] == d + w[i]) {
                    cnt[j] = (cnt[j] + cnt[v]) % mod;
                }
            }
        }
    }

    void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
