package maximum.running.time.of.n.computers;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumRunningTimeOfNComputers {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }
        for (int i = batteries.length - 1; i >= 0; i--) {
            if (batteries[i] > sum / n) {
                sum -= batteries[i];
                n--;
            } else {
                return sum / n;
            }
        }
        return -1;
    }
}
