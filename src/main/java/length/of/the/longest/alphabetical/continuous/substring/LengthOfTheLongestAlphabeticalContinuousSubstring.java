package length.of.the.longest.alphabetical.continuous.substring;

/**
 * @author hum
 */
public class LengthOfTheLongestAlphabeticalContinuousSubstring {
  public int longestContinuousSubstring(String s) {
    int len = s.length();
    int last = -2;
    int cnt = 1;
    int res = 0;
    for (int i = 0; i < len; i++) {
      int c = s.charAt(i) - 'a';
      if (c - last == 1) {
        cnt++;
      } else {
        cnt = 1;
      }
      res = Math.max(res, cnt);
      last = c;
    }
    return res;
  }
}
