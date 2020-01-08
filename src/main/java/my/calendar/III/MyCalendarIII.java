package my.calendar.III;

import java.util.TreeMap;

/**
 * @author hum
 */
public class MyCalendarIII {
    TreeMap<Integer, Integer> map;

    MyCalendarIII() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int active = 0, res = 0;
        for (int d : map.values()) {
            active += d;
            if (active > res) {
                res = active;
            }
        }
        return res;
    }
}
