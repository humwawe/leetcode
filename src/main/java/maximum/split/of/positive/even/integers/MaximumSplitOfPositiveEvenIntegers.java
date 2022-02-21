package maximum.split.of.positive.even.integers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class MaximumSplitOfPositiveEvenIntegers {
  public List<Long> maximumEvenSplit(long finalSum) {
    if (finalSum % 2 != 0) {
      return new ArrayList<>();
    }
    long t = 2;
    List<Long> res = new ArrayList<>();
    while (t <= finalSum) {
      res.add(t);
      finalSum -= t;
      t += 2;
    }
    long last = res.get(res.size() - 1);
    res.set(res.size() - 1, last + finalSum);
    return res;
  }
}
