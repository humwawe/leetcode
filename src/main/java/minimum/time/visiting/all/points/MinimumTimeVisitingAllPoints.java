package minimum.time.visiting.all.points;

/**
 * @author hum
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x = points[0][0];
        int y = points[0][1];
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            int tmpX = Math.abs(points[i][0] - x);
            int tmpY = Math.abs(points[i][1] - y);
            result += Math.max(tmpX, tmpY);
            x = points[i][0];
            y = points[i][1];
        }
        return result;
    }
}
