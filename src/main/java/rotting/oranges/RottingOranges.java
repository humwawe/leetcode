package rotting.oranges;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int result = 0;
        while (!queue.isEmpty()) {
            if (count == 0) {
                return result;
            }
            int size = queue.size();
            result++;
            while (size-- > 0) {
                int[] poll = queue.poll();
                for (int[] f : fs) {
                    int x = poll[0] + f[0];
                    int y = poll[1] + f[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 2;
                        count--;
                    }
                }
            }
        }
        return -1;
    }
}
