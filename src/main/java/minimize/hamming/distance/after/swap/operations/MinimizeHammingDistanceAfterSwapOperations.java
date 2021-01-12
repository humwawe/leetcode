package minimize.hamming.distance.after.swap.operations;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MinimizeHammingDistanceAfterSwapOperations {
    int[] p = new int[(int) (1e5 + 10)];

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int len = source.length;
        for (int i = 1; i <= len; i++) {
            p[i] = i;
        }
        for (int[] allowedSwap : allowedSwaps) {
            int a = allowedSwap[0];
            int b = allowedSwap[1];
            p[find(a)] = find(b);
        }
        int res = 0;
        Map<Integer, Map<Integer, Integer>> map1 = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int u = find(p[i]);
            if (map1.containsKey(u)) {
                map1.get(u).put(source[i], map1.get(u).getOrDefault(source[i], 0) + 1);
                map2.get(u).put(target[i], map2.get(u).getOrDefault(target[i], 0) + 1);
            } else {
                Map<Integer, Integer> cnt1 = new HashMap<>();
                Map<Integer, Integer> cnt2 = new HashMap<>();
                cnt1.put(source[i], 1);
                cnt2.put(target[i], 1);
                map1.put(u, cnt1);
                map2.put(u, cnt2);
            }
        }
        for (Integer integer : map1.keySet()) {
            Map<Integer, Integer> cnt1 = map1.get(integer);
            Map<Integer, Integer> cnt2 = map2.get(integer);
            for (Integer i : cnt1.keySet()) {
                res += Math.min(cnt1.get(i), cnt2.getOrDefault(i, 0));
            }
        }
        return len - res;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
