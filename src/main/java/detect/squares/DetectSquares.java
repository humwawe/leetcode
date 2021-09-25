package detect.squares;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class DetectSquares {
    int base = 2000;
    Map<Integer, Integer> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int key = point[0] * base + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0];
        int y = point[1];
        for (int key : map.keySet()) {
            int xx = key / base;
            int yy = key - xx * base;
            int a = Math.abs(xx - x);
            int b = Math.abs(yy - y);
            if (a != b || a == 0) {
                continue;
            }
            int key1 = x * base + yy;
            int key2 = xx * base + y;
            if (map.containsKey(key1) && map.containsKey(key2)) {
                res += map.get(key) * map.get(key1) * map.get(key2);
            }
        }
        return res;
    }

}
