package maximum.product.of.the.length.of.two.palindromic.subsequences;

/**
 * @author hum
 */
public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences {
    int n;
    char[] tmp = new char[15];

    public int maxProduct(String s) {
        n = s.length();
        int lim = 1 << n;
        int res = 0;
        for (int i = 1; i < lim; i++) {
            if (!check(s, i)) {
                continue;
            }
            int cnt = Integer.bitCount(i);
            for (int j = i + 1; j < lim; j++) {
                if ((i & j) != 0) {
                    continue;
                }
                if (check(s, j)) {
                    res = Math.max(res, cnt * Integer.bitCount(j));
                }
            }
        }
        return res;
    }

    private boolean check(String s, int i) {
        int num = 0;
        for (int j = 0; j < n; j++) {
            if (((i >> j) & 1) == 1) {
                tmp[num++] = s.charAt(j);
            }
        }
        for (int j = 0; j < num / 2; j++) {
            if (tmp[j] != tmp[num - 1 - j]) {
                return false;
            }
        }
        return true;
    }
}
