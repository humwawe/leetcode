package maximum.number.of.darts.inside.of.a.circular.dartboard;

/**
 * @author hum
 */
public class MaximumNumberOfDartsInsideOfACircularDartboard {
    double diff = 1e-8;

    public int numPoints(int[][] points, int r) {
        int res = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double x1 = points[i][0];
                double y1 = points[i][1];
                double x2 = points[j][0];
                double y2 = points[j][1];
                double q = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
                double y3 = (y1 + y2) / 2;
                double x3 = (x1 + x2) / 2;
                double a = Math.sqrt(Math.pow(r, 2) - Math.pow((q / 2), 2));
                double basex = a * (y1 - y2) / q;
                double basey = a * (x2 - x1) / q;
                double centerx1 = x3 + basex;
                double centery1 = y3 + basey;
                double centerx2 = x3 - basex;
                double centery2 = y3 - basey;
                res = Math.max(res, count(centerx1, centery1, r, points));
                res = Math.max(res, count(centerx2, centery2, r, points));
            }
        }
        return res;
    }

    int count(double x, double y, double r, int[][] points) {
        int cnt = 0;
        for (int[] point : points) {
            int a = point[0];
            int b = point[1];
            if ((a - x) * (a - x) + (b - y) * (b - y) <= r * r + diff) {
                cnt++;
            }
        }
        return cnt;
    }
}
