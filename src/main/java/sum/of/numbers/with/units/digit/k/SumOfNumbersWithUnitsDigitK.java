package sum.of.numbers.with.units.digit.k;

/**
 * @author hum
 */
public class SumOfNumbersWithUnitsDigitK {
  public int minimumNumbers(int num, int k) {
    if (num == 0) {
      return 0;
    }
    for (int i = 1; i <= 10; i++) {
      int t = num - i * k;
      if (t >= 0 && t % 10 == 0) {
        return i;
      }
    }
    return -1;
  }
}
