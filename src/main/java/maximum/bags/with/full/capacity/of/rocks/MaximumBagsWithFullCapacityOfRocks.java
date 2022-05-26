package maximum.bags.with.full.capacity.of.rocks;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumBagsWithFullCapacityOfRocks {
  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    int len = capacity.length;
    for (int i = 0; i < len; i++) {
      capacity[i] -= rocks[i];
    }
    Arrays.sort(capacity);
    int res = 0;
    for (int c : capacity) {
      if (additionalRocks >= c) {
        res++;
        additionalRocks -= c;
      } else {
        break;
      }
    }
    return res;
  }
}
