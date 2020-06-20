package frog.position.after.t.seconds;

import java.util.Arrays;

/**
 * @author hum
 */
public class FrogPositionAfterTSeconds {
    int[] h = new int[105];
    int[] e = new int[205];
    int[] ne = new int[205];
    int idx;
    int[] cnt = new int[105];
    double result = 0;
    int tar;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        Arrays.fill(h, -1);
        Arrays.fill(cnt, 0);
        tar = target;
        idx = 0;
        for (int[] edge : edges) {
            cnt[edge[0]]++;
            cnt[edge[1]]++;
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }
        cnt[1]++;

        helper(1, t, -1, 1);
        return result;
    }

    private void helper(int u, int t, int p, double prop) {
        if (t == 0) {
            if (tar == u) {
                result = prop;
            }
            return;
        }
        if (cnt[u] == 1) {
            helper(u, t - 1, p, prop);
            return;
        }
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            helper(j, t - 1, u, prop / (cnt[u] - 1));
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
