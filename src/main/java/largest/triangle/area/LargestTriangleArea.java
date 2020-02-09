package largest.triangle.area;

/**
 * @author hum
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    result = Math.max(result, Math.abs(points[i][0] * points[j][1] + points[i][1] * points[k][0] + points[j][0] * points[k][1] - points[i][0] * points[k][1] - points[i][1] * points[j][0] - points[j][1] * points[k][0]));
                }
            }
        }
        return result * 0.5;
    }
}
