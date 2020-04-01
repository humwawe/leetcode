package minimum.area.rectangle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        final int limit = 40000;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                if (set.contains(p1[0] * limit + p2[1]) && set.contains(p2[0] * limit + p1[1])) {
                    res = Math.min(res, Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1])));
                }
            }
            set.add(p1[0] * limit + p1[1]);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
