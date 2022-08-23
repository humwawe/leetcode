package shifting.letters.II;

/**
 * @author PF-2CRL0N
 */
public class ShiftingLettersII {
  public String shiftingLetters(String s, int[][] shifts) {
    int len = s.length();
    int[] diff = new int[len + 1];
    for (int[] shift : shifts) {
      int a = shift[0];
      int b = shift[1];
      if (shift[2] == 1) {
        diff[a]++;
        diff[b + 1]--;
      } else {
        diff[a]--;
        diff[b + 1]++;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      int c = s.charAt(i) - 'a';
      sb.append((char) ('a' + ((c + diff[i]) % 26 + 26) % 26));
      diff[i + 1] += diff[i];
    }
    return sb.toString();
  }
}
