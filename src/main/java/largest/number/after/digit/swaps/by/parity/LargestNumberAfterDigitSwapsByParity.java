package largest.number.after.digit.swaps.by.parity;

/**
 * @author hum
 */
public class LargestNumberAfterDigitSwapsByParity {
  public int largestInteger(int num) {
    String s = String.valueOf(num);
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int t = chars[i] - '0';
      int max = i;
      for (int j = i + 1; j < s.length(); j++) {
        if ((chars[j] - '0') % 2 == t % 2) {
          if (chars[j] > chars[max]) {
            max = j;
          }
        }
      }
      char tmp = chars[i];
      chars[i] = chars[max];
      chars[max] = tmp;
    }
    return Integer.parseInt(new String(chars));
  }
}
