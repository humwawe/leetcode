package number.of.boomerangs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        Map<Integer, Integer>[] cnt = new Map[len];
        for (int i = 0; i < points.length; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                int dis = (int) (Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                cnt[i].put(dis, cnt[i].getOrDefault(dis, 0) + 1);
                cnt[j].put(dis, cnt[j].getOrDefault(dis, 0) + 1);
            }
        }
        int result = 0;
        for (Map<Integer, Integer> map : cnt) {
            for (Integer integer : map.values()) {
                if (integer >= 2) {
                    result += integer * (integer - 1);
                }
            }
        }
        return result;
    }
}
