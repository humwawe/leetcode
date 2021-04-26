package maximum.building.height;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MaximumBuildingHeight {
    public int maxBuilding(int n, int[][] r) {
        Arrays.sort(r, Comparator.comparingInt(x -> x[0]));
        int len = r.length;
        if (len == 0) {
            return n;
        }
        long[] lMin = new long[len + 1];

        long[] rMin = new long[len + 1];
        long inf = (long) 1e12;
        Arrays.fill(lMin, inf);
        Arrays.fill(rMin, inf);
        lMin[0] = -1;
        rMin[len] = r[len - 1][0] + r[len - 1][1];
        for (int i = 1; i <= len; i++) {
            lMin[i] = Math.min(lMin[i - 1], r[i - 1][1] - r[i - 1][0]);
        }
        for (int i = len - 1; i > 0; i--) {
            rMin[i] = Math.min(rMin[i + 1], r[i - 1][1] + r[i - 1][0]);
        }
        long res = 0;
        for (int i = 1; i <= len; i++) {
            int idx = r[i - 1][0];
            res = Math.max(res, Math.min(idx + lMin[i], -idx + rMin[i]));
            if (i != len) {
                long y = (lMin[i] + rMin[i + 1]) / 2;
                long x = y - lMin[i];
                if (x >= r[i - 1][0] && x <= r[i][0]) {
                    res = Math.max(res, y);
                }
            } else {
                res = Math.max(res, n - idx + Math.min(lMin[i] + idx, r[i - 1][1]));
            }
        }
        return (int) res;
    }
}
