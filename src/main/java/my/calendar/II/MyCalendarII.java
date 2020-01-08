package my.calendar.II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class MyCalendarII {
    List<int[]> calendar;
    List<int[]> overlaps;

    MyCalendarII() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            if (overlap[0] < end && start < overlap[1]) {
                return false;
            }
        }
        for (int[] cal : calendar) {
            if (cal[0] < end && start < cal[1]) {
                overlaps.add(new int[]{Math.max(start, cal[0]), Math.min(end, cal[1])});
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}
