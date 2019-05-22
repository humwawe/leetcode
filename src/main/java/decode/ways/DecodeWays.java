package decode.ways;

/**
 * @author hum
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int sLength = s.length();
        int result[] = new int[sLength + 1];
        result[sLength - 1] = valid(s.charAt(sLength - 1)) ? 1 : 0;
        result[sLength] = 1;
        for (int i = sLength - 2; i >= 0; i--) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (c2 == '0' && !(c1 <= '2' && c1 >= '1') || c1 == '0') {
                result[i] = 0;
            } else if (c1 <= '1' || (c1 <= '2' && c2 <= '6')) {
                result[i] = result[i + 1] + result[i + 2];
            } else {
                result[i] = result[i + 1];
            }
        }
        return result[0];
    }

    private boolean valid(char c) {
        return c >= '1' && c <= '9';
    }
}
