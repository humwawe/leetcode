package find.longest.awesome.substr;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class FindLongestAwesomeSubstring {
    public int longestAwesome(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = s.length();
        int st = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            st ^= 1 << s.charAt(i) - '0';
            if (map.containsKey(st)) {
                result = Math.max(result, i - map.get(st));
            } else {
                map.put(st, i);
            }
            for (int j = 0; j < 10; j++) {
                if (map.containsKey(st ^ 1 << j)) {
                    result = Math.max(result, i - map.get(st ^ 1 << j));
                }
            }
        }
        return result;
    }
}
