package monotone.increasing.digits;

import java.util.Arrays;

/**
 * @author hum
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int len = s.length;
        int flag = s.length;
        for (int i = len - 1; i > 0; i--) {
            if (s[i] < s[i - 1]) {
                s[i - 1] -= 1;
                flag = i;
            }
        }
        Arrays.fill(s, flag, len, '9');
        return Integer.parseInt(String.valueOf(s));
    }
}
