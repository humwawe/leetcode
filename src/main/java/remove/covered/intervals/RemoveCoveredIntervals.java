package remove.covered.intervals;

import java.util.Arrays;

/**
 * @author hum
 */
public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0] == 0 ? b[1] - b[0] : a[0] - b[0]);
        int res = intervals.length;
        int len = intervals.length;
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][1] <= end) {
                res--;
            } else {
                end = intervals[i][1];
            }
        }
        return res;
    }
}
