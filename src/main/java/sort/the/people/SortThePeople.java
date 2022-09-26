package sort.the.people;

import java.util.Arrays;

/**
 * @author hum
 */
public class SortThePeople {
  public String[] sortPeople(String[] names, int[] heights) {
    int n = names.length;
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, (x, y) -> heights[y] - heights[x]);
    String[] res = new String[n];
    for (int i = 0; i < n; i++) {
      res[i] = names[idx[i]];
    }
    return res;

  }
}
