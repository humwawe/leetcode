package sort.integers.by.the.number.of.one.bits;

import java.util.Arrays;

/**
 * @author hum
 */
public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        int len = arr.length;
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;

        }
        Arrays.sort(idx, (a, b) -> helper(arr[a]) == helper(arr[b]) ? arr[a] - arr[b] : helper(arr[a]) - helper(arr[b]));
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = arr[idx[i]];
        }
        return result;
    }

    int helper(int a) {
        int res = 0;
        while (a != 0) {
            a -= a & (a - 1);
            res++;
        }
        return res;
    }
}
