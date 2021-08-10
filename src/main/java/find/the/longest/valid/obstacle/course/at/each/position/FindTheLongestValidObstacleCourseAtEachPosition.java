package find.the.longest.valid.obstacle.course.at.each.position;

/**
 * @author hum
 */
public class FindTheLongestValidObstacleCourseAtEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int len = obstacles.length;
        int[] tmp = new int[len];
        int[] res = new int[len];
        int idx = 0;
        res[0] = 1;
        tmp[idx++] = obstacles[0];
        for (int i = 1; i < len; i++) {
            int l = upperBound(tmp, obstacles[i], 0, idx);
            res[i] = l + 1;
            tmp[l] = obstacles[i];
            if (l == idx) {
                idx++;
            }
        }
        return res;
    }

    int upperBound(int[] a, int t, int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] <= t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
