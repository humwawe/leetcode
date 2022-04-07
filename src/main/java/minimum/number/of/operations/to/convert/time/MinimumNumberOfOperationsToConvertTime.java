package minimum.number.of.operations.to.convert.time;

/**
 * @author hum
 */
public class MinimumNumberOfOperationsToConvertTime {
  public int convertTime(String current, String correct) {
    int a = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3));
    int b = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3));
    int diff = a - b;
    int res = 0;
    res += diff / 60;
    diff %= 60;
    res += diff / 15;
    diff %= 15;
    res += diff / 5;
    diff %= 5;
    res += diff;
    return res;
  }
}
