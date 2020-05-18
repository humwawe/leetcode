package shortest.path.in.binary.matrix;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class ShortestPathInBinaryMatrix {
    int[][] fs = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1) {
            return -1;
        }
        int[][] d = new int[len][len];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        d[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == len - 1 && poll[1] == len - 1) {
                return d[len - 1][len - 1];
            }
            for (int[] f : fs) {
                int i = poll[0] + f[0];
                int j = poll[1] + f[1];
                if (i >= 0 && i < len && j >= 0 && j < len && d[i][j] == 0 && grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    d[i][j] = d[poll[0]][poll[1]] + 1;
                }
            }
        }
        return -1;
    }
}
