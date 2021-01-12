package number.of.ways.to.reconstruct.a.tree;

import java.util.*;

/**
 * @author hum
 */
public class NumberOfWaysToReconstructATree {
    public int checkWays(int[][] pairs) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 505; i++) {
            adj.add(new ArrayList<>());
        }
        int[] cnt = new int[505];
        Set<Integer> set = new HashSet<>();
        for (int[] p : pairs) {
            adj.get(p[0]).add(p[1]);
            adj.get(p[1]).add(p[0]);
            cnt[p[0]]++;
            cnt[p[1]]++;
            set.add(p[0]);
            set.add(p[1]);
        }
        int[] par = new int[505];
        Arrays.fill(par, -1);

        List<Integer> sorted = new ArrayList<>(set);
        sorted.sort((x, y) -> cnt[y] - cnt[x]);
        int ans = 1;
        if (cnt[sorted.get(0)] != sorted.size() - 1) {
            return 0;
        }
        Set<Integer> vis = new HashSet<>();
        for (Integer u : sorted) {
            for (Integer v : adj.get(u)) {
                if (cnt[v] == cnt[u]) {
                    ans = 2;
                }
                if (!vis.contains(v)) {
                    if (par[u] != par[v]) {
                        return 0;
                    }
                    par[v] = u;
                }
                vis.add(u);
            }
        }
        return ans;
    }
}
