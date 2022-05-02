package total.appeal.of.a.string;

import java.util.Arrays;

/**
 * @author hum
 */
public class TotalAppealOfAString {
  public long appealSum(String s) {
    long res = 0L;
    int[] pos = new int[26];
    Arrays.fill(pos, -1);
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i) - 'a';
      sum += i - pos[x];
      res += sum;
      pos[x] = i;
    }
    return res;

  }
}
