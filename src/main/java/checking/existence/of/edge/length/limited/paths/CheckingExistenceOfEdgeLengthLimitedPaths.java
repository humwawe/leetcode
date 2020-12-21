package checking.existence.of.edge.length.limited.paths;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class CheckingExistenceOfEdgeLengthLimitedPaths {
    int[] p;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        Arrays.sort(edgeList, Comparator.comparingInt(x -> x[2]));
        Integer[] idx = new Integer[queries.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(x -> queries[x][2]));
        boolean[] res = new boolean[queries.length];
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = idx[i];
            while (j < edgeList.length && edgeList[j][2] < queries[index][2]) {
                p[find(edgeList[j][0])] = find(edgeList[j][1]);
                j++;
            }
            res[index] = find(queries[index][0]) == find(queries[index][1]);
        }
        return res;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
