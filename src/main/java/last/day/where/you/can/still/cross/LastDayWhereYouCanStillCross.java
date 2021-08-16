package last.day.where.you.can.still.cross;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author hum
 */
public class LastDayWhereYouCanStillCross {
    int row;
    int col;
    int[][] cells;

    public int latestDayToCross(int row, int col, int[][] cells) {
        int len = cells.length;
        this.row = row;
        this.col = col;
        this.cells = cells;
        int l = 0;
        int r = len;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int mid) {
        Set<Integer> set = new HashSet<>();
        int base = 2005;
        for (int i = 0; i < mid; i++) {
            set.add(cells[i][0] * base + cells[i][1]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= col; i++) {
            if (set.contains(base + i)) {
                continue;
            }
            queue.add(base + i);
            set.add(base + i);
        }
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (cur / base == row) {
                return true;
            }
            for (int[] f : fs) {
                int x = cur / base + f[0];
                int y = cur % base + f[1];
                int tmp = x * base + y;
                if (x >= 1 && x <= row && y >= 1 && y <= col && !set.contains(tmp)) {
                    queue.add(tmp);
                    set.add(tmp);
                }
            }
        }
        return false;
    }
}
