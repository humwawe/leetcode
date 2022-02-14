package removing.minimum.number.of.magic.beans;

import java.util.Arrays;

/**
 * @author hum
 */
public class RemovingMinimumNumberOfMagicBeans {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int len = beans.length;

        long sum = 0;
        for (int bean : beans) {
            sum += bean;
        }
        long t = 0;
        long res = sum;
        for (int i = 0; i < len; i++) {
            long tmp = t + (sum - t - (long) beans[i] * (len - i));
            res = Math.min(res, tmp);
            t += beans[i];
        }
        return res;
    }
}
