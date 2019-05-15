package merge.intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || (intervals.length == 1 && intervals[0].length == 0)) {
            return intervals;
        }
        sort(intervals);
        List<int[]> result = new ArrayList<>();
        int[] tmp = new int[2];
        for (int i = 0; i < intervals.length; i++) {
            tmp[0] = intervals[i][0];
            int maxLen = intervals[i][1];
            while (i + 1 < intervals.length && maxLen >= intervals[i + 1][0]) {
                maxLen = Math.max(maxLen, intervals[i + 1][1]);
                i++;
            }
            tmp[1] = maxLen;
            result.add(tmp);
        }

        return result.toArray(new int[0][]);
    }

    private void sort(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            for (int i = 0; i < 2; i++) {
                if (o1[i] > o2[i]) {
                    return 1;
                } else if (o1[i] < o2[i]) {
                    return -1;
                }
            }
            return 0;
        });

    }
}
