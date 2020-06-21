package count.largest.group;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int t = helper(i);
            map.put(t, map.getOrDefault(t, 0) + 1);
            res = Math.max(res, map.get(t));
        }
        int result = 0;
        for (Integer integer : map.values()) {
            if (integer == res) {
                result++;
            }
        }
        return result;
    }

    private int helper(int i) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i /= 10;
        }

        return res;
    }
}
