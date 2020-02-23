package hand.of.straights;

import java.util.TreeMap;

/**
 * @author hum
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int w) {
        if (hand.length % w != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (!map.isEmpty()) {
            Integer min = map.firstKey();
            for (int i = 0; i < w; i++) {
                Integer count = map.get(i + min);
                if (count == null) {
                    return false;
                }
                if (count == 1) {
                    map.remove(i + min);
                } else {
                    map.put(min + i, count - 1);
                }
            }
        }
        return true;
    }
}
