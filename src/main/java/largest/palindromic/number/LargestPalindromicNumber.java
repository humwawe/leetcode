package largest.palindromic.number;

/**
 * @author hum
 */
public class LargestPalindromicNumber {
  public String largestPalindromic(String num) {
    int[] cnt = new int[10];
    for (char c : num.toCharArray()) {
      cnt[c - '0']++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 9; i >= 0; i--) {
      while (cnt[i] > 1 && (sb.length() > 0 || i > 0)) {
        sb.append(i);
        cnt[i] -= 2;
      }
    }
    for (int i = 9; i >= 0; i--) {
      if (cnt[i] > 0) {
        return sb.toString() + i + sb.reverse();
      }
    }
    return sb.toString() + sb.reverse();
  }
}
