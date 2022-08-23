package time.needed.to.rearrange.a.binary.string;

/**
 * @author hum
 */
public class TimeNeededToRearrangeABinaryString {
  public int secondsToRemoveOccurrences(String s) {
    int cnt = 0;
    int len = s.length();
    int res = 0;
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '0') {
        cnt++;
      } else if (cnt > 0) {
        res = Math.max(res + 1, cnt);
      }
    }
    return res;
  }
}
