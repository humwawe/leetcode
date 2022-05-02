package remove.digit.from.number.to.maximize.result;

/**
 * @author hum
 */
public class RemoveDigitFromNumberToMaximizeResult {
  public String removeDigit(String number, char digit) {
    String max = "0";
    for (int i = 0; i < number.length(); i++) {
      if (number.charAt(i) == digit) {
        String tmp = new StringBuilder(number).deleteCharAt(i).toString();
        if (tmp.compareTo(max) > 0) {
          max = tmp;
        }
      }
    }
    return max;
  }
}
