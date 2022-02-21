package find.three.consecutive.integers.that.sum.to.a.given.number;

/**
 * @author hum
 */
public class FindThreeConsecutiveIntegersThatSumToAGivenNumber {
  public long[] sumOfThree(long num) {
    long[] res = new long[3];
    if (num % 3 == 0) {
      res[1] = num / 3;
      res[0] = res[1] - 1;
      res[2] = res[1] + 1;
      return res;
    } else {
      return new long[]{};
    }
  }
}
