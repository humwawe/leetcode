package the.k.strongest.values.in.an.array;

import java.util.Arrays;

/**
 * @author hum
 */
public class TheKStrongestValuesInAnArray {
    public int[] getStrongest(int[] arr, int k) {
        int len = arr.length;
        Arrays.sort(arr);
        int m = arr[(len - 1) / 2];
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> {
            int t = Math.abs(arr[b] - m) - Math.abs(arr[a] - m);
            if (t == 0) {
                return arr[b] - arr[a];
            }
            return t;
        });
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[idx[i]];
        }
        return result;
    }
}
