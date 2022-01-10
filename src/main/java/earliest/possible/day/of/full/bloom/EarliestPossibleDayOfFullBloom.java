package earliest.possible.day.of.full.bloom;

import java.util.Arrays;

/**
 * @author hum
 */
public class EarliestPossibleDayOfFullBloom {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        int sum = 0;

        Arrays.sort(idx, (x, y) -> growTime[y] - growTime[x]);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = idx[i];
            sum += plantTime[j];
            res = Math.max(res, sum + growTime[j]);
        }
        return res;
    }
}
