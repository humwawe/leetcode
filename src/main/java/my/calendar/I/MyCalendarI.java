package my.calendar.I;

import java.util.TreeMap;

/**
 * @author hum
 */
public class MyCalendarI {
    TreeMap<Integer, Integer> map;

    public MyCalendarI() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if ((prev == null || map.get(prev) <= start) && (next == null || next >= end)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}
