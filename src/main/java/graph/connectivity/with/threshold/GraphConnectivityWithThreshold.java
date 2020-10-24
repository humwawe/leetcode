package graph.connectivity.with.threshold;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class GraphConnectivityWithThreshold {
    int[] p;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        p = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                p[find(j)] = find(i);
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(find(query[0]) == find(query[1]));
        }
        return result;

    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
