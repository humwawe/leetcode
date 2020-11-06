package widest.vertical.area.between.two.points.containing.no.points;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(x -> x[0]));
        int res = 0;
        int len = points.length;
        for (int i = 1; i < len; i++) {
            res = Math.max(res, points[i][0] - points[i - 1][0]);
        }
        return res;
    }
}
