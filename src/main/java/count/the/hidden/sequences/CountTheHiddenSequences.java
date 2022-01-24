package count.the.hidden.sequences;

/**
 * @author hum
 */
public class CountTheHiddenSequences {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int res = upper - lower + 1;
        int l = lower;
        int r = upper;
        for (int difference : differences) {
            l = l + difference;
            r = r + difference;
            l = Math.max(lower, l);
            r = Math.min(r, upper);
            if (r < l) {
                return 0;
            }
            res = Math.min(res, r - l + 1);
        }
        return res;
    }
}
