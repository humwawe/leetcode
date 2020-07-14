package best.positionfo.a.service.centre;

/**
 * @author hum
 */
public class BestPositionForAServiceCentre {
    double eps = 1e-6;
    int[][] p;

    public double getMinDistSum(int[][] positions) {
        double l = 0;
        double r = 100;
        p = positions;
        double x = 0;
        double y = 0;
        while (l + eps < r) {
            double mid = (l + r) / 2;
            double lm = (l + mid) / 2;
            double rm = (mid + r) / 2;
            double ly = getY(lm);
            double ry = getY(rm);
            x = mid;
            if (dist(lm, ly) > dist(rm, ry)) {
                y = ry;
                l = lm;
            } else {
                y = ly;
                r = rm;
            }
        }
        return dist(x, y);
    }

    private double getY(double x) {
        double l = 0;
        double r = 100;
        while (l + eps < r) {
            double mid = (l + r) / 2;
            double lm = (l + mid) / 2;
            double rm = (mid + r) / 2;
            if (dist(x, lm) > dist(x, rm)) {
                l = lm;
            } else {
                r = rm;
            }
        }
        return l;
    }

    private double dist(double x, double y) {
        double res = 0;
        for (int[] ints : p) {
            res += Math.sqrt((x - ints[0]) * (x - ints[0]) + (y - ints[1]) * (y - ints[1]));
        }
        return res;
    }
}
