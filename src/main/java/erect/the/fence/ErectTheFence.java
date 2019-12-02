package erect.the.fence;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class ErectTheFence {
    public int[][] outerTrees(int[][] points) {
        Set<int[]> hull = new HashSet<>();
        int len = points.length;
        if (len < 4) {
            return points;
        }
        int leftMost = 0;
        for (int i = 0; i < len; i++) {
            if (points[i][0] < points[leftMost][0]) {
                leftMost = i;
            }
        }
        int p = leftMost;
        do {
            int q = (p + 1) % len;
            for (int i = 0; i < len; i++) {
                if (orientation(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }
            for (int i = 0; i < len; i++) {
                if (i != p && i != q && orientation(points[p], points[i], points[q]) == 0 && inBetween(points[p], points[i], points[q])) {
                    hull.add(points[i]);
                }
            }
            hull.add(points[q]);
            p = q;
        }
        while (p != leftMost);
        return hull.toArray(new int[0][]);
    }

    private int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    private boolean inBetween(int[] p, int[] i, int[] q) {
        boolean a = i[0] >= p[0] && i[0] <= q[0] || i[0] <= p[0] && i[0] >= q[0];
        boolean b = i[1] >= p[1] && i[1] <= q[1] || i[1] <= p[1] && i[1] >= q[1];
        return a && b;
    }
}
