package naming.a.company;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class NamingACompany {
  public long distinctNames(String[] ideas) {
    Set<String> all = new HashSet<>();
    Collections.addAll(all, ideas);
    int[][] cnt = new int[26][26];
    for (String s : ideas) {
      int a = s.charAt(0) - 'a';
      StringBuilder sb = new StringBuilder(s);
      for (int i = 0; i < 26; i++) {
        if (i == a) {
          continue;
        }
        sb.setCharAt(0, (char) (i + 'a'));
        if (!all.contains(sb.toString())) {
          cnt[a][i]++;
        }
      }
    }
    long res = 0;
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        res += cnt[i][j] * cnt[j][i];
      }
    }
    return res;
  }
}
