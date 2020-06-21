package circle.and.rectangle.overlapping;

/**
 * @author hum
 */
public class CircleAndRectangleOverlapping {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double x0 = (x1 + x2) / 2.0;
        double y0 = (y1 + y2) / 2.0;

        double[] p = new double[]{Math.abs(xCenter - x0), Math.abs(yCenter - y0)};
        double[] q = new double[]{x2 - x0, y2 - y0};

        double[] u = {Math.max(p[0] - q[0], 0.0), Math.max(p[1] - q[1], 0.0)};

        return Math.sqrt(u[0] * u[0] + u[1] * u[1]) <= radius;
    }
}
