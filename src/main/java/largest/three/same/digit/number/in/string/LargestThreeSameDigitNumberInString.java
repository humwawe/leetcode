package largest.three.same.digit.number.in.string;

/**
 * @author hum
 */
public class LargestThreeSameDigitNumberInString {
  public String largestGoodInteger(String num) {
    int len = num.length();
    String res = "";
    f:
    for (int i = 0; i + 3 <= len; i++) {
      for (int j = 0; j < 3; j++) {
        if (num.charAt(i) != num.charAt(i + j)) {
          continue f;
        }
      }
      String sub = num.substring(i, i + 3);
      if (sub.compareTo(res) > 0) {
        res = sub;
      }
    }
    return res;
  }
}
