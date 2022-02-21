package construct.string.with.repeat.limit;

/**
 * @author hum
 */
public class ConstructStringWithRepeatLimit {
  public String repeatLimitedString(String s, int repeatLimit) {
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    int last = -1;
    while (true) {
      boolean f = false;
      int max = -1;
      for (int i = 25; i >= 0; i--) {
        if (cnt[i] > 0) {
          max = i;
          break;
        }
      }
      if (max == -1) {
        break;
      }

      for (int i = 25; i >= 0; i--) {
        if (cnt[i] > 0 && i != last) {
          f = true;
          if (i != max) {
            for (int j = 0; j < 1; j++) {
              sb.append((char) (i + 'a'));
            }
            cnt[i] -= 1;
          } else {
            for (int j = 0; j < Math.min(repeatLimit, cnt[i]); j++) {
              sb.append((char) (i + 'a'));
            }
            cnt[i] -= Math.min(repeatLimit, cnt[i]);
          }
          last = i;
          break;
        }
      }
      if (!f) {
        break;
      }
    }
    return sb.toString();
  }
}
