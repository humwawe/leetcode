package find.the.k.beauty.of.a.number;

/**
 * @author hum
 */
public class FindTheKBeautyOfANumber {
  public int divisorSubstrings(int num, int k) {
    String s = String.valueOf(num);
    int n = s.length();
    int res = 0;
    for (int i = 0; i + k <= n; i++) {
      int t = Integer.parseInt(s.substring(i, i + k));
      if (t != 0 && num % t == 0) {
        res++;
      }
    }
    return res;
  }
}
