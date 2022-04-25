package number.of.flowers.in.full.bloom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NumberOfFlowersInFullBloom {
  public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
    List<int[]> list = new ArrayList<>();
    int inf = (int) (1e9 + 5);
    for (int[] flower : flowers) {
      list.add(new int[]{flower[0], inf});
      list.add(new int[]{flower[1] + 1, -inf});
    }
    for (int i = 0, personsLength = persons.length; i < personsLength; i++) {
      list.add(new int[]{persons[i], i});
    }

    list.sort((x, y) -> {
      int d = x[0] - y[0];
      if (d == 0) {
        return Math.abs(y[1]) - Math.abs(x[1]);
      }
      return d;
    });
    int cnt = 0;
    int[] res = new int[persons.length];
    for (int[] point : list) {
      if (point[1] == inf) {
        cnt++;
      } else if (point[1] == -inf) {
        cnt--;
      } else {
        res[point[1]] = cnt;
      }
    }
    return res;
  }
}
