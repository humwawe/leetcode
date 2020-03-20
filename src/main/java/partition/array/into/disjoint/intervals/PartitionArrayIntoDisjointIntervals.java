package partition.array.into.disjoint.intervals;


import java.util.Arrays;

/**
 * @author hum
 */
public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] a) {
        int len = a.length;
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = a[0];
        min[len - 1] = (int) 1e7;
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(a[i], max[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            min[i] = Math.min(a[i + 1], min[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            if (max[i] <= min[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}
