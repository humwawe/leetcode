package data.stream.as.disjoint.intervals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class DataStreamAsDisjointIntervals {
    List<int[]> intervals;
    Set<Integer> set;

    public DataStreamAsDisjointIntervals() {
        intervals = new ArrayList<>();
        set = new HashSet<>();
    }

    public void addNum(int val) {
        if (set.contains(val)) {
            return;
        }
        if (!set.contains(val - 1) && !set.contains(val + 1)) {
            int i = 0;
            for (i = 0; i < intervals.size(); i++) {
                if (intervals.get(i)[0] > val) {
                    break;
                }
            }
            int[] tmp = new int[]{val, val};
            intervals.add(i, tmp);
        }
        for (int i = 0; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);
            if (interval[0] == val + 1) {
                interval[0] = val;
                break;
            } else if (interval[1] == val - 1) {
                interval[1] = val;
                if (i < intervals.size() - 1 && val == intervals.get(i + 1)[0] - 1) {
                    interval[1] = intervals.get(i + 1)[1];
                    intervals.remove(i + 1);
                    break;
                }
            }
        }
        set.add(val);
    }

    public int[][] getIntervals() {
        return intervals.toArray(new int[0][]);
    }
}
