package cinema.seat.allocation;

import java.util.*;

/**
 * @author hum
 */
public class CinemaSeatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            if (!map.containsKey(reservedSeat[0])) {
                map.put(reservedSeat[0], new HashSet<>());
            }
            map.get(reservedSeat[0]).add(reservedSeat[1]);
        }
        int result = 2 * n;
        for (Integer k : map.keySet()) {
            Set<Integer> set = map.get(k);
            int count = 0;
            if (isOk(2, 5, set)) {
                count++;
                if (isOk(6, 9, set)) {
                    count++;
                }
            } else {
                if (isOk(4, 7, set)) {
                    count++;
                } else {
                    if (isOk(6, 9, set)) {
                        count++;
                    }
                }
            }
            result -= 2 - count;
        }
        return result;
    }

    private boolean isOk(int l, int r, Set<Integer> set) {
        for (int i = l; i <= r; i++) {
            if (set.contains(i)) {
                return false;
            }
        }
        return true;
    }

}
