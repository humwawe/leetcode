package flip.string.to.monotone.increasing;


/**
 * @author hum
 */
public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            sum[i + 1] = sum[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j <= len; ++j) {
            result = Math.min(result, sum[j] + len - j - (sum[len] - sum[j]));
        }
        return result;
    }
}
