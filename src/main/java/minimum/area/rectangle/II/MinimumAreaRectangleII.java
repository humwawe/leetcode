package minimum.area.rectangle.II;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class MinimumAreaRectangleII {
    public double minAreaFreeRect(int[][] points) {
        int len = points.length;
        Point[] a = new Point[len];
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            a[i] = new Point(points[i][0], points[i][1]);
            set.add(a[i]);
        }

        double ans = Double.MAX_VALUE;
        for (int i = 0; i < len; ++i) {
            Point p1 = a[i];
            for (int j = 0; j < len; ++j) {
                if (j != i) {
                    Point p2 = a[j];
                    for (int k = j + 1; k < len; ++k) {
                        if (k != i) {
                            Point p3 = a[k];
                            Point p4 = new Point(p2.x + p3.x - p1.x, p2.y + p3.y - p1.y);
                            if (set.contains(p4)) {
                                int dot = ((p2.x - p1.x) * (p3.x - p1.x) + (p2.y - p1.y) * (p3.y - p1.y));
                                if (dot == 0) {
                                    double area = p1.distance(p2) * p1.distance(p3);
                                    if (area < ans) {
                                        ans = area;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans < Double.MAX_VALUE ? ans : 0;
    }
}
