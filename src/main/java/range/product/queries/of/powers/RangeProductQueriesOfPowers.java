package range.product.queries.of.powers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class RangeProductQueriesOfPowers {
  public int[] productQueries(int n, int[][] queries) {
    int mod = (int) (1e9 + 7);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 30; i++) {
      if ((n >> i & 1) == 1) {
        list.add(1 << i);
      }
    }
    int[] res = new int[queries.length];

    for (int j = 0; j < queries.length; j++) {
      int[] query = queries[j];
      long t = 1;
      for (int i = query[0]; i <= query[1]; i++) {
        t *= list.get(i);
        t %= mod;
      }
      res[j] = (int) t;
    }
    return res;
  }
}
