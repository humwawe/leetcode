package calculate.digit.sum.of.a.string;

/**
 * @author hum
 */
public class CalculateDigitSumOfAString {
  public String digitSum(String s, int k) {
    if (s.length() <= k) {
      return s;
    }

    StringBuilder sb = new StringBuilder();
    int len = s.length();
    for (int i = 0; i < len; i += k) {
      int sum = 0;
      for (int t = 0; t < k && i + t < len; t++) {
        sum += (s.charAt(i + t) - '0');
      }

      sb.append(sum);
    }
    return digitSum(sb.toString(), k);
  }

}
