package split.message.based.on.limit;

/**
 * @author hum
 */
public class SplitMessageBasedOnLimit {
  public String[] splitMessage(String message, int limit) {
    int n = message.length();
    for (int i = 1, cap = 0, tailLen; ; ++i) {
      if (i < 10) {
        tailLen = 5;
      } else if (i < 100) {
        if (i == 10) {
          cap -= 9;
        }
        tailLen = 7;
      } else if (i < 1000) {
        if (i == 100) {
          cap -= 99;
        }
        tailLen = 9;
      } else {
        if (i == 1000) {
          cap -= 999;
        }
        tailLen = 11;
      }
      if (tailLen >= limit) {
        return new String[]{};
      }
      cap += limit - tailLen;
      if (cap < n) {
        continue;
      }

      String[] res = new String[i];
      for (int j = 0, k = 0; j < i; ++j) {
        String tail = "<" + (j + 1) + "/" + i + ">";
        if (j == i - 1) {
          res[j] = message.substring(k) + tail;
        } else {
          int m = limit - tail.length();
          res[j] = message.substring(k, k + m) + tail;
          k += m;
        }
      }
      return res;
    }
  }
}
