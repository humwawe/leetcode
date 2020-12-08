package generate.random.point.in.a.circle;

/**
 * @author hum
 */
public class GenerateRandomPointInACircle {
    private double r;
    private double x;
    private double y;

    public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double[] result = new double[2];
        double a = Math.toRadians(Math.random() * 360);
        double len = r * Math.sqrt(Math.random());
        result[0] = Math.cos(a) * len + x;
        result[1] = Math.sin(a) * len + y;
        return result;
    }
}
