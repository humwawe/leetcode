package maximum.number.of.visible.points;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class MaximumNumberOfVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        double eps = 1e-8;
        List<Double> list = new ArrayList<>();
        int same = 0;
        int lx = location.get(0);
        int ly = location.get(1);
        for (List<Integer> point : points) {
            int px = point.get(0);
            int py = point.get(1);
            if (px == lx && py == ly) {
                same++;
                continue;
            }
            list.add(getAngle(px, py, lx, ly));
        }
        list.sort(Comparator.naturalOrder());
        int len = list.size();
        for (int i = 0; i < len; ++i) {
            list.add(list.get(i) + 360d);
        }
        int r = 0, max = 0;
        int size = list.size();
        for (int l = 0; l < size; ++l) {
            while (r < size && (list.get(r) - list.get(l)) < (angle + eps)) {
                r++;
            }
            max = Math.max(max, r - l);
        }
        return max + same;
    }

    public double getAngle(int px, int py, int lx, int ly) {
        //直接算出度数，atan2值域(-π,π]
        double angle = Math.toDegrees(Math.atan2(py - ly, px - lx));
        if (angle < 0) {
            angle += 360d;
        }
        return angle;
    }
}
