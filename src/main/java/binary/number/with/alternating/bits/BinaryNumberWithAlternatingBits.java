package binary.number.with.alternating.bits;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class BinaryNumberWithAlternatingBits {
    public static boolean hasAlternatingBits(int n) {
        if (n == 0) {
            return true;
        }
        String s = Integer.toBinaryString(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != '1') {
                return false;
            }
            if (i + 1 < s.length() && s.charAt(i + 1) != '0') {
                return false;
            }
        }
        return true;
    }
}
