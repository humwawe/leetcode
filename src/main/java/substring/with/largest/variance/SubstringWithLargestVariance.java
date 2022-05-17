package substring.with.largest.variance;

/**
 * @author hum
 */
public class SubstringWithLargestVariance {
  public int largestVariance(String s) {
    int len = s.length();
    int res = 0;
    for (char i = 'a'; i <= 'z'; i++) {
      for (char j = 'a'; j <= 'z'; j++) {
        if (i == j) {
          continue;
        }
        int[] sum = new int[len + 1];
        int l = 0;
        int min = (int) 1e9;
        for (int k = 0; k < len; k++) {
          char c = s.charAt(k);
          int t = 0;
          if (c == i) {
            t = 1;
          } else if (c == j) {
            t = -1;
            while (l <= k) {
              min = Math.min(min, sum[l]);
              l++;
            }
          }
          sum[k + 1] = sum[k] + t;

          res = Math.max(res, sum[k + 1] - min);
        }
      }
    }
    return res;
  }

}
