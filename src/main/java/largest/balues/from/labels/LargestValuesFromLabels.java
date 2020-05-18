package largest.balues.from.labels;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int len = values.length;
        Integer[] t = new Integer[len];
        for (int i = 0; i < len; i++) {
            t[i] = i;
        }
        Arrays.sort(t, (a, b) -> values[b] - values[a]);
        int[] vis = new int[20005];
        int result = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int idx = t[i];
            if (vis[labels[idx]] > useLimit) {
                continue;
            }
            result += values[idx];
            vis[labels[idx]]++;
            count++;
            if (count == numWanted) {
                return result;
            }
        }

        return result;
    }

}
