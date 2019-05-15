package insert.interval;

import java.util.Arrays;

/**
 * @author hum
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0 || (intervals.length == 1 && intervals[0].length == 0)) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        int low = 0, high = 0;

        int left = 0;
        int right = intervals.length - 1;
        boolean finded = false;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (intervals[mid][1] > newInterval[0]) {
                right = mid - 1;
            } else if (intervals[mid][1] < newInterval[0]) {
                left = mid + 1;
            } else {
                finded = true;
                low = mid - 1;
                break;
            }

        }
        if (!finded) {
            low = left - 1;
        }

        left = 0;
        right = intervals.length - 1;
        finded = false;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (intervals[mid][0] > newInterval[1]) {
                right = mid - 1;
            } else if (intervals[mid][0] < newInterval[1]) {
                left = mid + 1;
            } else {
                finded = true;
                high = mid + 1;
                break;
            }
        }
        if (!finded) {
            high = left;
        }
        int[] tmp = new int[2];
        if (low + 1 == intervals.length || high - 1 < 0) {
            tmp = newInterval;
        } else {
            tmp[0] = Math.min(intervals[low + 1][0], newInterval[0]);
            tmp[1] = Math.max(intervals[high - 1][1], newInterval[1]);
        }

        int[][] result = new int[intervals.length - high + low + 1 + 1][2];
        int index = 0;
        while (index <= low) {
            result[index] = intervals[index];
            index++;
        }
        result[index++] = tmp;
        while (high < intervals.length) {
            result[index++] = intervals[high++];
        }
        return result;
    }
}
