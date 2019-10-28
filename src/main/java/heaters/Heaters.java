package heaters;

import java.util.TreeSet;

/**
 * @author hum
 */
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        int len = houses.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int heater : heaters) {
            set.add(heater);
        }

        int left = 0, right = 1000000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(set, houses, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(TreeSet<Integer> set, int[] houses, int mid) {
        for (int house : houses) {
            Integer floor = set.floor(house);
            if (floor == null || floor + mid < house) {
                Integer higher = set.higher(house);
                if (higher == null || higher - mid > house) {
                    return false;
                }
            }
        }
        return true;
    }
}
