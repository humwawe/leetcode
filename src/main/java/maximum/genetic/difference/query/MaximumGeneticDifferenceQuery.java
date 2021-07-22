package maximum.genetic.difference.query;

import java.util.*;

/**
 * @author hum
 */
public class MaximumGeneticDifferenceQuery {
    int[] h;
    int[] e;
    int[] ne;
    int idx;
    int root;
    int[][] son;
    int[] cnt;
    int idx2;
    int lim;
    int[] res;
    Map<Integer, List<int[]>> map;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = parents.length;
        h = new int[n];
        e = new int[n];
        ne = new int[n];
        Arrays.fill(h, -1);
        idx = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                root = i;
                continue;
            }
            add(parents[i], i);
        }

        idx2 = 0;
        lim = 18;
        son = new int[n * lim][2];
        cnt = new int[n * lim];
        res = new int[queries.length];
        map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            if (!map.containsKey(queries[i][0])) {
                map.put(queries[i][0], new ArrayList<>());
            }
            map.get(queries[i][0]).add(new int[]{queries[i][1], i});
        }
        dfs(root);
        return res;

    }

    private void dfs(int u) {
        insert(u);
        List<int[]> list = map.get(u);
        if (list != null) {
            for (int[] q : list) {
                res[q[1]] = query(q[0]);
            }
        }

        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);
        }
        delete(u);
    }

    private void delete(int u) {
        int p = 0;
        for (int i = lim - 1; i >= 0; i--) {
            cnt[p]--;
            int x = (u >> i) & 1;
            p = son[p][x];
        }
        cnt[p]--;
    }

    void insert(int u) {
        int p = 0;
        for (int i = lim - 1; i >= 0; i--) {
            cnt[p]++;
            int x = (u >> i) & 1;
            if (son[p][x] == 0) {
                son[p][x] = ++idx;
            }
            p = son[p][x];
        }
        cnt[p]++;
    }

    int query(int u) {
        int ans = u;
        int p = 0;
        for (int i = lim - 1; i >= 0; i--) {
            int x = (u >> i) & 1;
            if (son[p][x ^ 1] > 0 && cnt[son[p][x ^ 1]] > 0) {
                x = x ^ 1;
            }
            ans ^= x << i;
            p = son[p][x];
        }
        return ans;
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
