package number.of.ways.to.split.a.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class NumberOfWaysToSplitAString {
    public int numWays(String s) {
        int mod = (int) (1e9 + 7);
        int len = s.length();
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
                map.put(cnt, i);
            }
        }
        if (cnt % 3 != 0) {
            return 0;
        }
        if (cnt == 0) {
            return (int) ((long) (len - 1) * (len - 2) / 2 % mod);
        }
        int a = map.get(cnt / 3);
        int b1 = map.get(cnt / 3 + 1);
        int b2 = map.get(cnt / 3 * 2);
        int c = map.get(cnt / 3 * 2 + 1);
        return (int) ((long) (b1 - a) * (c - b2) % mod);
    }
}
