package perfect.rectangle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        int p1 = Integer.MAX_VALUE;
        int p2 = Integer.MIN_VALUE;
        int p3 = Integer.MIN_VALUE;
        int p4 = Integer.MAX_VALUE;

        Set<String> set = new HashSet<>();
        int sumArea = 0;

        for (int[] rectangle : rectangles) {
            p1 = Math.min(p1, rectangle[0]);
            p4 = Math.min(p4, rectangle[1]);
            p2 = Math.max(p2, rectangle[2]);
            p3 = Math.max(p3, rectangle[3]);
            sumArea += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
            String lt = rectangle[0] + " " + rectangle[3];
            String lb = rectangle[0] + " " + rectangle[1];
            String rt = rectangle[2] + " " + rectangle[3];
            String rb = rectangle[2] + " " + rectangle[1];
            if (!set.add(lt)) {
                set.remove(lt);
            }
            if (!set.add(lb)) {
                set.remove(lb);
            }
            if (!set.add(rt)) {
                set.remove(rt);
            }
            if (!set.add(rb)) {
                set.remove(rb);
            }
        }

        if (set.size() == 4 && set.contains(p1 + " " + p3) && set.contains(p1 + " " + p4) && set.contains(p2 + " " + p4) && set.contains(p2 + " " + p3)) {
            return sumArea == (p2 - p1) * (p3 - p4);
        }
        return false;
    }
}
