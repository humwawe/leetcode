package queries.on.number.of.points.inside.a.circle;

/**
 * @author hum
 */
public class QueriesOnNumberOfPointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = 0;
            for (int[] point : points) {
                int a = point[0] - queries[i][0];
                int b = point[1] - queries[i][1];
                if (a * a + b * b <= queries[i][2] * queries[i][2]) {
                    res[i] += 1;
                }
            }
        }
        return res;
    }
}
