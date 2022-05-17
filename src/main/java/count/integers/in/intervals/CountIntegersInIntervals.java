package count.integers.in.intervals;

import java.util.TreeMap;

/**
 * @author hum
 */
public class CountIntegersInIntervals {
  TreeMap<Integer, Integer> map = new TreeMap<>();
  int cnt;

  public CountIntegersInIntervals() {
  }

  public void add(int left, int right) {
    for (var e = map.ceilingEntry(left); e != null && e.getValue() <= right; e = map.ceilingEntry(left)) {
      int l = e.getValue();
      int r = e.getKey();
      left = Math.min(left, l);
      right = Math.max(right, r);
      cnt -= r - l + 1;
      map.remove(r);
    }
    cnt += right - left + 1;
    map.put(right, left);
  }

  public int count() {
    return cnt;
  }

}
