package largest.plus.sign;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author hum
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Map<Integer, TreeSet<Integer>> map1 = new HashMap<>();
        Map<Integer, TreeSet<Integer>> map2 = new HashMap<>();
        for (int[] mine : mines) {
            if (map1.containsKey(mine[0])) {
                map1.get(mine[0]).add(mine[1]);
            } else {
                TreeSet<Integer> tmp = new TreeSet<>();
                tmp.add(mine[1]);
                map1.put(mine[0], tmp);
            }
            if (map2.containsKey(mine[1])) {
                map2.get(mine[1]).add(mine[0]);
            } else {
                TreeSet<Integer> tmp = new TreeSet<>();
                tmp.add(mine[0]);
                map2.put(mine[1], tmp);
            }
        }

        int result = 0;
        for (int i = 0; i < n - result; i++) {
            for (int j = 0; j < n - result; j++) {
                if (map1.containsKey(i) && map1.get(i).contains(j)) {
                    continue;
                }
                int tmp1 = 0, tmp2 = 0;
                if (map1.containsKey(i)) {
                    TreeSet<Integer> treeSet = map1.get(i);
                    Integer floor = treeSet.floor(j);
                    if (floor == null) {
                        floor = -1;
                    }
                    if (j - floor < result) {
                        continue;
                    }
                    Integer ceiling = treeSet.ceiling(j);
                    if (ceiling == null) {
                        ceiling = n;
                    }
                    if (ceiling - j < result) {
                        continue;
                    }
                    tmp1 = Math.min(j - floor - 1, ceiling - j - 1);
                } else {
                    tmp1 = Math.min(j, n - 1 - j);
                    if (tmp1 < result) {
                        continue;
                    }
                }

                if (map2.containsKey(j)) {
                    TreeSet<Integer> treeSet = map2.get(j);
                    Integer floor = treeSet.floor(i);
                    if (floor == null) {
                        floor = -1;
                    }
                    if (i - floor < result) {
                        continue;
                    }
                    Integer ceiling = treeSet.ceiling(i);
                    if (ceiling == null) {
                        ceiling = n;
                    }
                    if (ceiling - i < result) {
                        continue;
                    }
                    tmp2 = Math.min(i - floor - 1, ceiling - i - 1);
                } else {
                    tmp2 = Math.min(i, n - 1 - i);
                    if (tmp2 < result) {
                        continue;
                    }
                }
                result = Math.min(tmp1, tmp2) + 1;
            }
        }
        return result;
    }
}
