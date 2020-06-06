package minimum.moves.to.reach.target.with.rotations;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class MinimumMovesToReachTargetWithRotations {
    public int minimumMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][][] d = new int[row][col][2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Arrays.fill(d[i][j], -1);
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        d[0][0][0] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int f = poll[2];
            if (f == 0) {
                if (y + 2 < col && grid[x][y + 2] == 0 && d[x][y + 1][0] == -1) {
                    queue.add(new int[]{x, y + 1, 0});
                    d[x][y + 1][0] = d[x][y][0] + 1;
                }
                if (x + 1 < row && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && d[x + 1][y][0] == -1) {
                    queue.add(new int[]{x + 1, y, 0});
                    d[x + 1][y][0] = d[x][y][0] + 1;
                }
                if (x + 1 < row && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && d[x][y][1] == -1) {
                    queue.add(new int[]{x, y, 1});
                    d[x][y][1] = d[x][y][0] + 1;
                }
            } else {
                if (x + 2 < row && grid[x + 2][y] == 0 && d[x + 1][y][1] == -1) {
                    queue.add(new int[]{x + 1, y, 1});
                    d[x + 1][y][1] = d[x][y][1] + 1;
                }
                if (y + 1 < col && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0 && d[x][y + 1][1] == -1) {
                    queue.add(new int[]{x, y + 1, 1});
                    d[x][y + 1][1] = d[x][y][1] + 1;
                }
                if (y + 1 < col && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0 && d[x][y][0] == -1) {
                    queue.add(new int[]{x, y, 0});
                    d[x][y][0] = d[x][y][1] + 1;
                }
            }
        }
        return d[row - 1][col - 2][0];
    }
}
