package count.pairs.of.nodes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class CountPairsOfNodes {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] in = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            in[edge[0]]++;
            in[edge[1]]++;
            int key = Math.min(edge[0], edge[1]) * 100000 + Math.max(edge[0], edge[1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        Integer[] idx = new Integer[n + 1];
        for (int i = 0; i <= n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, 1, n + 1, Comparator.comparingInt(x -> in[x]));
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int limit = queries[i];
            int l = 1;
            for (int r = n; r > l; r--) {
                while (l < r && in[idx[r]] + in[idx[l]] <= limit) {
                    l++;
                }
                if (l < r) {
                    res[i] += r - l;
                }
            }
            for (Integer key : map.keySet()) {
                int u = key / 100000;
                int v = key % 100000;
                if (in[u] + in[v] > limit && in[u] + in[v] - map.get(key) <= limit) {
                    res[i] -= 1;
                }
            }
        }
        return res;
    }
}
