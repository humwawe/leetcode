package minimum.increment.to.make.array.unique;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] a) {
        Arrays.sort(a);
        int curmax = -1;
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= curmax) {
                int ai = curmax + 1;
                res += (ai - a[i]);
                a[i] = ai;
            }
            curmax = Math.max(curmax, a[i]);
        }
        return res;
    }
}
