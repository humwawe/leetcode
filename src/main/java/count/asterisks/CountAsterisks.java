package count.asterisks;

/**
 * @author hum
 */
public class CountAsterisks {
  public int countAsterisks(String s) {
    int ct = 0;
    int st = 0;
    for (char c : s.toCharArray()) {
      if (c == '|') {
        st ^= 1;
      }
      if (c == '*' && st == 0) {
        ct++;
      }
    }
    return ct;
  }
}
