package arithmetic.slices.II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        long ans = 0;
        Map<Integer, Integer>[] cnt = new Map[len];
        for (int i = 0; i < len; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long) A[i] - (long) A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) delta;
                int sum = cnt[j].getOrDefault(diff, 0);
                int origin = cnt[i].getOrDefault(diff, 0);
                cnt[i].put(diff, origin + sum + 1);
                ans += sum;
            }
        }
        return (int) ans;
    }
}
