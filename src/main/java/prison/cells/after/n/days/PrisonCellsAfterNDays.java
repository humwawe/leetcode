package prison.cells.after.n.days;

import java.util.*;

/**
 * @author hum
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer, int[]> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int[] tmp = next(cells);
        for (int i = 1; i <= n; i++) {
            String key = Arrays.toString(tmp);
            if (set.contains(key)) {
                break;
            }
            set.add(key);
            map.put(i, tmp);
            tmp = next(tmp);
        }
        int period = set.size();
        int day = n % period;
        return map.get(day == 0 ? period : day);
    }

    private int[] next(int[] cur) {
        int[] res = new int[8];
        for (int i = 1; i < 7; i++) {
            res[i] = (cur[i - 1] ^ cur[i + 1]) == 0 ? 1 : 0;
        }
        return res;
    }
}
