package grid.illumination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class GridIllumination {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Set<String> set = new HashSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        Map<Integer, Integer> map4 = new HashMap<>();
        for (int[] lamp : lamps) {
            int x = lamp[0];
            int y = lamp[1];
            map1.put(x, map1.getOrDefault(x, 0) + 1);
            map2.put(y, map2.getOrDefault(y, 0) + 1);
            map3.put(x - y, map3.getOrDefault(x - y, 0) + 1);
            map4.put(y + x, map4.getOrDefault(y + x, 0) + 1);
            set.add(String.valueOf(x) + "#" + String.valueOf(y));
        }
        int[] result = new int[queries.length];
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}, {0, 0}};
        for (int i = 0, queriesLength = queries.length; i < queriesLength; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (map1.containsKey(x) || map2.containsKey(y) || map3.containsKey(x - y) || map4.containsKey(y + x)) {
                result[i] = 1;
            }
            for (int[] f : fs) {
                int t1 = f[0] + x;
                int t2 = f[1] + y;
                if (t1 < 0 || t1 >= n || t2 < 0 || t2 >= n) {
                    continue;
                }
                String t = String.valueOf(t1) + "#" + String.valueOf(t2);
                if (set.contains(t)) {
                    set.remove(t);
                    map1.put(t1, map1.get(t1) - 1);
                    if (map1.get(t1) == 0) {
                        map1.remove(t1);
                    }
                    map2.put(t2, map2.get(t2) - 1);
                    if (map2.get(t2) == 0) {
                        map2.remove(t2);
                    }
                    map3.put(t1 - t2, map3.get(t1 - t2) - 1);
                    if (map3.get(t1 - t2) == 0) {
                        map3.remove(t1 - t2);
                    }
                    map4.put(t2 + t1, map4.get(t2 + t1) - 1);
                    if (map4.get(t2 + t1) == 0) {
                        map4.remove(t2 + t1);
                    }
                }
            }
        }
        return result;
    }

}
