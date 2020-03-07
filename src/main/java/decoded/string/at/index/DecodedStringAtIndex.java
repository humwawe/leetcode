package decoded.string.at.index;

/**
 * @author hum
 */
public class DecodedStringAtIndex {
    public String decodeAtIndex(String s, int k) {
        long count = 0;
        int i = 0;
        for (; count < k; i++) {
            if (Character.isDigit(s.charAt(i))) {
                count *= s.charAt(i) - '0';
            } else {
                count++;
            }
        }
        while (i-- > 0) {
            if (Character.isDigit(s.charAt(i))) {
                count /= s.charAt(i) - '0';
                k %= count;
            } else {
                if (k % count == 0) {
                    return String.valueOf(s.charAt(i));
                }
                count--;
            }
        }
        return "";
    }
}
