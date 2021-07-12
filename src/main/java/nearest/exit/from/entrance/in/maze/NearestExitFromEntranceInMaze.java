package nearest.exit.from.entrance.in.maze;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{entrance[0], entrance[1]});
        boolean[][] vis = new boolean[row][col];
        vis[entrance[0]][entrance[1]] = true;
        int step = 0;
        int[][] fs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] != entrance[0] || cur[1] != entrance[1]) {
                    if (cur[0] == row - 1 || cur[0] == 0 || cur[1] == col - 1 || cur[1] == 0) {
                        return step;
                    }
                }
                for (int[] f : fs) {
                    int x = cur[0] + f[0];
                    int y = cur[1] + f[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && !vis[x][y] && maze[x][y] == '.') {
                        queue.add(new int[]{x, y});
                        vis[x][y] = true;
                    }
                }

            }
            step++;
        }
        return -1;
    }
}
