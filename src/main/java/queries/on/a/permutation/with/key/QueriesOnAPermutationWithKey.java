package queries.on.a.permutation.with.key;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class QueriesOnAPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }
        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < queries.length; i++) {
            int index = list.indexOf(queries[i]);
            result[i] = index;
            list.remove(index);
            list.add(0, queries[i]);
        }
        return result;
    }
}
