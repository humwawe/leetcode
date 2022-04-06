package sum.of.scores.of.built.strings;

/**
 * @author hum
 */
public class SumOfScoresOfBuiltStrings {
  public long sumScores(String s) {
    int[] tmp = zFunction(s);
    long res = 0;
    for (int i = 1; i < tmp.length; i++) {
      res += tmp[i];
    }
    res += s.length();
    return res;
  }

  int[] zFunction(String s) {
    int n = s.length();
    int[] z = new int[n];
    for (int i = 1, l = 0, r = 0; i < n; ++i) {
      if (i <= r && z[i - l] < r - i + 1) {
        z[i] = z[i - l];
      } else {
        z[i] = Math.max(0, r - i + 1);
        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
          ++z[i];
        }
      }
      if (i + z[i] - 1 > r) {
        l = i;
        r = i + z[i] - 1;
      }
    }
    return z;
  }
}
