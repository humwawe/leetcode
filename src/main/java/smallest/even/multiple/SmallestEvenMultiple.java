package smallest.even.multiple;

/**
 * @author hum
 */
public class SmallestEvenMultiple {
  public int smallestEvenMultiple(int n) {
    if (n % 2 != 0) {
      return n * 2;
    } else {
      return n;
    }
  }
}
