package count.binary.substrings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char prev = s.charAt(0);
        int count = 0;
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                list.add(count);
                prev = c;
                count = 1;
            }
        }
        list.add(count);
        int result = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            result += Math.min(list.get(i), list.get(i + 1));
        }
        return result;
    }
}
