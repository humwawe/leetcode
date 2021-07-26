package sum.of.digits.of.string.after.convert;

/**
 * @author hum
 */
public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        String tmp = "";
        for (char c : s.toCharArray()) {
            tmp += "" + (c - 'a' + 1);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = 0;
            for (char c : tmp.toCharArray()) {
                res += c - '0';
            }
            tmp = String.valueOf(res);
        }
        return res;
    }
}
