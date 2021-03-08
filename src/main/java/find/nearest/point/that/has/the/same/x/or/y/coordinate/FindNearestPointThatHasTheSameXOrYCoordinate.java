package find.nearest.point.that.has.the.same.x.or.y.coordinate;

/**
 * @author hum
 */
public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                if (Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y) < min) {
                    min = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                    res = i;
                }
            }
        }
        return res;
    }
}
