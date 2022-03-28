package find.palindrome.with.fixed.length;

/**
 * @author hum
 */
public class FindPalindromeWithFixedLength {
  public long[] kthPalindrome(int[] queries, int intLength) {
    int preLen = (intLength + 1) / 2;
    int lastLen = intLength - preLen;
    long start = 1;
    for (int i = 0; i < preLen - 1; i++) {
      start *= 10;
    }
    long[] res = new long[queries.length];
    for (int i = 0; i < queries.length; i++) {
      long tmp = start + (queries[i] - 1);
      String s = String.valueOf(tmp);
      if (s.length() > preLen) {
        res[i] = -1;
      } else {
        StringBuilder sb = new StringBuilder(s.substring(0, lastLen));
        s = s + sb.reverse();
        res[i] = Long.parseLong(s);
      }
    }
    return res;
  }
}
