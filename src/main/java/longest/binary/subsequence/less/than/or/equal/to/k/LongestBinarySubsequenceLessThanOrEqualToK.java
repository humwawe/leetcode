package longest.binary.subsequence.less.than.or.equal.to.k;

/**
 * @author hum
 */
public class LongestBinarySubsequenceLessThanOrEqualToK {
  public int longestSubsequence(String s, int k) {
    long sum = 0;
    int cnt = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        cnt++;
      } else {
        if (cnt <= 40 && sum + (1L << cnt) <= k) {
          sum += (1L << cnt);
          cnt++;
        }
      }
    }

    return cnt;

  }
}
