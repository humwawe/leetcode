package merge.similar.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class MergeSimilarItems {
  public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
    List<List<Integer>> res = new ArrayList<>();
    int[] map = new int[1001];
    for (int[] p : items1) {
      map[p[0]] += p[1];
    }
    for (int[] p : items2) {
      map[p[0]] += p[1];
    }
    for (int i = 0; i <= 1000; i++) {
      if (map[i] != 0) {
        res.add(Arrays.asList(i, map[i]));
      }
    }
    return res;
  }
}
