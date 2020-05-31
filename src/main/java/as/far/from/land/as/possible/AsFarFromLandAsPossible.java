package as.far.from.land.as.possible;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] d = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(d[i], -1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    d[i][j] = 0;
                }
            }
        }
        int[][] fs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int result = -1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] f : fs) {
                int x = poll[0] + f[0];
                int y = poll[1] + f[1];
                if (x >= 0 && x < row && y >= 0 && y < col) {
                    if (d[x][y] != -1) {
                        continue;
                    }
                    d[x][y] = d[poll[0]][poll[1]] + 1;
                    result = Math.max(result, d[x][y]);
                    queue.add(new int[]{x, y});
                }
            }
        }
        return result;
    }
}
