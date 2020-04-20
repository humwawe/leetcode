package interval.list.intersections;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            int lo = Math.max(a[i][0], b[j][0]);
            int hi = Math.min(a[i][1], b[j][1]);
            if (lo <= hi) {
                result.add(new int[]{lo, hi});
            }

            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
