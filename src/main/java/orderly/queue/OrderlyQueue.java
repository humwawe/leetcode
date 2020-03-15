package orderly.queue;

import java.util.Arrays;

/**
 * @author hum
 */
public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
        String result = s;
        for (int i = 0; i < s.length(); ++i) {
            String t = s.substring(i) + s.substring(0, i);
            if (t.compareTo(result) < 0) {
                result = t;
            }
        }
        return result;
    }
}
