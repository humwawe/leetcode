package valid.arrangement.of.pairs;

import java.util.Arrays;

/**
 * @author hum
 */
public class ValidArrangementOfPairs {
    int[] a;
    int len = 0;
    int N = 100010;
    int M = N;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;

    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length;
        a = new int[n * 2];
        for (int i = 0; i < n; i++) {
            a[i] = pairs[i][0];
            a[i + n] = pairs[i][1];
        }
        discrete();
        Arrays.fill(h, -1);
        idx = 0;
        int[] cnt = new int[len + 5];
        for (int[] pair : pairs) {
            int x = find(pair[0]);
            int y = find(pair[1]);
            cnt[x]++;
            cnt[y]--;
            add(x, y);
        }
        int root = 1;
        for (int i = 0; i < len; i++) {
            if (cnt[i] % 2 == 1) {
                root = i;
                break;
            }
        }
        dfs2(root);
        int[][] res = new int[n][2];
        int j = 0;
        for (int i = t - 1; i >= 1; i--) {
            res[j][0] = a[result[i]];
            res[j][1] = a[result[i - 1]];
            j++;
        }
        return res;
    }

    boolean[] vis = new boolean[M];
    int[] result = new int[M];
    int t = 0;

    void dfs2(int u) {
        while (true) {
            int i = h[u];
            while (i != -1 && vis[i]) {
                i = ne[i];
            }
            if (i != -1) {
                h[u] = ne[i];
                vis[i] = true;
                int j = e[i];
                dfs2(j);
            } else {
                break;
            }
        }
        result[t++] = u;
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    void discrete() {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || a[i] != a[i - 1]) {
                a[len++] = a[i];
            }
        }
    }

    public int find(int x) {
        return Arrays.binarySearch(a, 0, len, x);
    }
}
