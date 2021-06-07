package minimum.number.of.flips.to.make.the.binary.string.alternating;

/**
 * @author hum
 */
public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {
    int len;

    public int minFlips(String s) {
        len = s.length();
        s += s;
        return Math.min(check(s, 0), check(s, 1));
    }

    private int check(String s, int u) {
        int j = 0;
        int cnt = 0;
        int res = (int) 1e8;
        int tmp = u;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != u) {
                cnt++;
            }
            if (i - j + 1 > len) {
                if (s.charAt(i) - '0' != tmp) {
                    cnt--;
                }
                tmp = 1 - tmp;
                j++;
            }
            if (i - j + 1 == len) {
                res = Math.min(res, cnt);
            }
            u = 1 - u;
        }
        return res;
    }
}
