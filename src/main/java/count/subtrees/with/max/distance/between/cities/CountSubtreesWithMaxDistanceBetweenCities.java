package count.subtrees.with.max.distance.between.cities;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CountSubtreesWithMaxDistanceBetweenCities {
    int[][] e;
    int N = 20;
    int[][] dist = new int[N][N];

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        e = edges;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 0x3f3f3f3f;
                }
            }
        }
        for (int[] edge : edges) {
            dist[edge[0] - 1][edge[1] - 1] = 1;
            dist[edge[1] - 1][edge[0] - 1] = 1;
        }
        floyd(n);

        int[] res = new int[n - 1];
        int limit = 1 << n;
        for (int i = 0; i < limit; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    set.add(j);
                }
            }
            if (set.size() == 1) {
                continue;
            }
            if (!isC(set)) {
                continue;
            }
            int t = helper(set) - 1;
            res[t]++;
        }
        return res;
    }

    void floyd(int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    private int helper(Set<Integer> set) {
        int res = 0;
        for (Integer i : set) {
            for (Integer j : set) {
                res = Math.max(res, dist[i][j]);
            }
        }
        return res;
    }

    private boolean isC(Set<Integer> set) {
        int cnt = 0;
        for (int[] ints : e) {
            if (set.contains(ints[0] - 1) && set.contains(ints[1] - 1)) {
                cnt++;
            }
        }
        return set.size() - 1 == cnt;
    }
}
