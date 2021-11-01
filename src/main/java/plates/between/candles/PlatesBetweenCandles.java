package plates.between.candles;

import java.util.TreeSet;

/**
 * @author hum
 */
public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length();
        int[] sum = new int[len + 1];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i];
            if (s.charAt(i) == '|') {
                sum[i + 1]++;
                set.add(i);
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            Integer l = set.ceiling(query[0]);
            Integer r = set.floor(query[1]);
            if (l == null || r == null || l >= r) {
                continue;
            }
            res[i] = r - l + 1 - (sum[r + 1] - sum[l]);
        }
        return res;
    }
}
