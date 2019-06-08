package max.points.on.a.line;

/**
 * @author hum
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2) {
            return len;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            int same = 1;
            for (int j = i + 1; j < len; j++) {
                int cnt = 0;
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    same++;
                } else {
                    cnt++;
                    long xDiff = (long) (points[i][0] - points[j][0]);
                    long yDiff = (long) (points[i][1] - points[j][1]);
                    for (int k = j + 1; k < len; k++) {
                        if (xDiff * (points[i][1] - points[k][1]) == yDiff * (points[i][0] - points[k][0])) {
                            cnt++;
                        }
                    }
                }
                max = Math.max(max, cnt + same);
            }
        }
        return max;
    }
}
