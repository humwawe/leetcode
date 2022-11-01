package average.value.of.even.numbers.that.are.divisible.by.three;

/**
 * @author hum
 */
public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
  public int averageValue(int[] nums) {
    int sum = 0;
    int cnt = 0;
    for (int num : nums) {
      if (num % 3 == 0 && num % 2 == 0) {
        sum += num;
        cnt++;
      }
    }
    if (cnt > 0) {
      return sum / cnt;
    }
    return 0;
  }
}
