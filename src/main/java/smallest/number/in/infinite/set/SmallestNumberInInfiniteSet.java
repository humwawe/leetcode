package smallest.number.in.infinite.set;

import java.util.TreeSet;

/**
 * @author hum
 */
public class SmallestNumberInInfiniteSet {
  int minVal = 1;
  TreeSet<Integer> set = new TreeSet();

  public SmallestNumberInInfiniteSet() {

  }

  public int popSmallest() {
    if (set.size() == 0) {
      return minVal++;
    }
    return set.pollFirst();
  }

  public void addBack(int num) {
    if (num < minVal) {
      set.add(num);
    }
  }
}
