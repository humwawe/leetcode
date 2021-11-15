package most.beautiful.item.each.query;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MostBeautifulItemForEachQuery {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int len = queries.length;
        Integer[] idx = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(x -> queries[x]));
        Arrays.sort(items, Comparator.comparingInt(x -> x[0]));
        int j = 0;
        int max = 0;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int q = queries[idx[i]];
            while (j < items.length && items[j][0] <= q) {
                max = Math.max(max, items[j][1]);
                j++;
            }
            res[idx[i]] = max;
        }
        return res;
    }
}
