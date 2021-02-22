package tree.of.coprimes;

import java.util.Arrays;

/**
 * @author hum
 */
public class TreeOfCoprimes {
    int[] h;
    int[] e;
    int[] ne;
    int[] d;
    int idx;
    int[] nums;
    int[] res;
    boolean[][] g = new boolean[55][55];

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int len = nums.length;
        res = new int[len];
        Arrays.fill(res, -1);
        this.nums = nums;
        for (int i = 1; i < 55; i++) {
            for (int j = 1; j < 55; j++) {
                if (gcd(i, j) == 1) {
                    g[i][j] = true;
                }
            }
        }

        h = new int[len];
        Arrays.fill(h, -1);
        e = new int[len * 2];
        ne = new int[len * 2];
        d = new int[len];
        idx = 0;
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }

        int[] cnt = new int[55];
        Arrays.fill(cnt, -1);
        cnt[nums[0]] = 0;
        dfs(0, -1, cnt);
        return res;
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    private void dfs(int u, int p, int[] cnt) {
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            d[j] = d[u] + 1;
            int tmp = (int) -1e8;
            for (int k = 1; k <= 50; k++) {
                if (cnt[k] != -1 && g[nums[j]][k]) {
                    if (tmp < d[cnt[k]]) {
                        tmp = d[cnt[k]];
                        res[j] = cnt[k];
                    }
                }
            }
            int old = cnt[nums[j]];
            cnt[nums[j]] = j;
            dfs(j, u, cnt);
            cnt[nums[j]] = old;
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
