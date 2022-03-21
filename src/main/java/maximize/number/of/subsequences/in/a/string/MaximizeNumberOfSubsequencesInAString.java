package maximize.number.of.subsequences.in.a.string;

/**
 * @author hum
 */
public class MaximizeNumberOfSubsequencesInAString {
  public long maximumSubsequenceCount(String text, String pattern) {
    char a = pattern.charAt(0);
    char b = pattern.charAt(1);
    int cnta = 0;
    int cntb = 0;
    long res = 0;

    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == b) {
        cntb++;
        res += cnta;
      }
      if (text.charAt(i) == a) {
        cnta++;
      }
    }
    return Math.max(res + cnta, res + cntb);
  }
}
