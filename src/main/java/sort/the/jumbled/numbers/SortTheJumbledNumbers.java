package sort.the.jumbled.numbers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class SortTheJumbledNumbers {
  public int[] sortJumbled(int[] mapping, int[] nums) {
    int len = nums.length;
    Integer[] idx = new Integer[len];
    for (int i = 0; i < len; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> helper(mapping, nums[x])));
    int[] res = new int[len];
    for (int i = 0; i < len; i++) {
      res[i] = nums[idx[i]];
    }
    return res;
  }

  private int helper(int[] mapping, Integer x) {
    if (x == 0) {
      return mapping[0];
    }
    int res = 0;
    int base = 1;
    while (x > 0) {
      int a = mapping[x % 10];
      res += a * base;
      base *= 10;
      x /= 10;
    }
    return res;
  }
}
