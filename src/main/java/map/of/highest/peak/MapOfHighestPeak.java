package map.of.highest.peak;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class MapOfHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int row = isWater.length;
        int col = isWater[0].length;
        int[][] res = new int[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = -1;
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    res[i][j] = 0;
                }
            }
        }
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] f : fs) {
                int x = cur[0] + f[0];
                int y = cur[1] + f[1];
                if (x >= 0 && x < row && y >= 0 && y < col && res[x][y] == -1) {
                    res[x][y] = res[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return res;
    }
}
