package minimum.time.to.collect.all.apples.in.a.tree;

import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class MinimumTimeToCollectAllApplesInATree {
    int N = 100010;
    int M = N * 2;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Arrays.fill(h, -1);
        idx = 0;
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }
        int res = helper(0, hasApple, -1);
        if (res <= 0) {
            return res + 1;
        }
        return res;
    }

    private int helper(int u, List<Boolean> hasApple, int p) {
        int res = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            int t = helper(j, hasApple, u);
            if (t != -1) {
                res += 2 + t;
            }
        }
        if (res == 0) {
            if (!hasApple.get(u)) {
                return -1;
            } else {
                return 0;
            }
        }
        return res;
    }
}
