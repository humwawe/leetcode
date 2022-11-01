package sum.of.number.and.its.reverse;

/**
 * @author hum
 */
public class SumOfNumberAndItsReverse {
  public boolean sumOfNumberAndReverse(int num) {
    for (int i = 0; i <= 100000; i++) {
      int r = 0;
      int j = i;
      while (j > 0) {
        r = r * 10 + j % 10;
        j /= 10;
      }
      if (i + r == num) {
        return true;
      }
    }
    return false;
  }
}
