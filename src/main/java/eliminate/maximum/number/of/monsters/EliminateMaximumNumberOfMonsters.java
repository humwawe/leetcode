package eliminate.maximum.number.of.monsters;

import java.util.Arrays;

/**
 * @author hum
 */
public class EliminateMaximumNumberOfMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] times = new double[n];

        for (int i = 0; i < n; i++) {
            times[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(times);

        for (int i = 0; i < n; i++) {
            if (i >= times[i] + 1e-8) {
                return i;
            }
        }
        return n;
    }
}
