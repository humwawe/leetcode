package number.of.substrings.only.ones;

/**
 * @author hum
 */
public class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        int res = 0;
        int mod = (int) 1e9 + 7;
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                cnt = 0;
            } else {
                cnt++;
                res += cnt;
                res %= mod;
            }
        }
        return res;
    }
}
