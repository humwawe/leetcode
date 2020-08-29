package find.latest.group.of.size.m;

import java.util.TreeSet;

/**
 * @author hum
 */
public class FindLatestGroupOfSizeM {
    public int findLatestStep(int[] arr, int m) {
        int len = arr.length;
        if (m == len) {
            return m;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        treeSet.add(len + 1);
        for (int i = len - 1; i >= 0; i--) {
            int divIndex = arr[i];
            int lower = treeSet.lower(divIndex);
            int higher = treeSet.higher(divIndex);
            if (divIndex - lower - 1 == m || higher - divIndex - 1 == m) {
                return i;
            } else {
                treeSet.add(divIndex);
            }
        }
        return -1;
    }
}
