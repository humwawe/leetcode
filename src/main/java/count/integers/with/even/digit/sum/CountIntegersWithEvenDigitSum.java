package count.integers.with.even.digit.sum;

/**
 * @author hum
 */
public class CountIntegersWithEvenDigitSum {
  public int countEven(int num) {
    int res = 0;
    for (int i = 2; i <= num; i++) {
      if (check(i)) {
        res++;
      }
    }
    return res;
  }

  private boolean check(int i) {
    int res = 0;
    while (i > 0) {
      res += i % 10;
      i /= 10;
    }
    return res % 2 == 0;
  }
}
