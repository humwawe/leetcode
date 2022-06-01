package check.number.has.equal.digit.count.and.digit.value;

/**
 * @author hum
 */
public class CheckIfNumberHasEqualDigitCountAndDigitValue {
  public boolean digitCount(String num) {
    int[] cnt = new int[10];
    for (char c : num.toCharArray()) {
      cnt[c - '0']++;
    }
    for (int i = 0; i < num.length(); i++) {
      if (num.charAt(i) - '0' != cnt[i]) {
        return false;
      }
    }
    return true;
  }
}
