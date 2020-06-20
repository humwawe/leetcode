package sort.integers.by.the.power.value;

import java.util.Arrays;

/**
 * @author hum
 */
public class SortIntegersByThePowerValue {
    int[] d = new int[(int) 1e5];

    public int getKth(int lo, int hi, int k) {
        Arrays.fill(d, -1);
        d[1] = 0;
        Integer[] idx = new Integer[hi - lo + 1];
        for (int i = 0; i <= hi - lo; i++) {
            idx[i] = i;
        }
        for (int i = lo; i <= hi; i++) {
            if (d[i] == -1) {
                helper(lo);
            }

        }
        Arrays.sort(idx, (a, b) -> d[a + lo] == d[b + lo] ? a - b : d[a + lo] - d[b + lo]);

        return idx[k] + lo;

    }

    private int helper(int i) {
        if (d[i] != -1) {
            return d[i];
        }
        if (i % 2 == 0) {
            return d[i] = helper(i / 2) + 1;
        } else {
            return d[i] = helper(i * 3 + 1) + 1;
        }
    }
}
