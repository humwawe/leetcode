package matrix.cells.in.distance.order;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author hum
 */
public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int r, int c, int r0, int c0) {
        int[][] fs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[r * c][2];
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        queue.add(new int[]{r0, c0});
        set.add(r0 * 100 + c0);
        int index = 0;
        result[index][0] = r0;
        result[index][1] = c0;
        index++;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] f : fs) {
                int i = poll[0] + f[0];
                int j = poll[1] + f[1];
                int t = i * 100 + j;
                if (i >= 0 && i < r && j >= 0 && j < c && !set.contains(t)) {
                    queue.add(new int[]{i, j});
                    result[index][0] = i;
                    result[index][1] = j;
                    set.add(t);
                    index++;
                }
            }
        }
        return result;
    }
}
