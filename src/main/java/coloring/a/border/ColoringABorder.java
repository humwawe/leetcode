package coloring.a.border;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class ColoringABorder {
    private int[][] fs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int t = grid[r0][c0];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r0, c0});
        visited[r0][c0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pol = queue.poll();
                int r = pol[0];
                int c = pol[1];
                for (int[] f : fs) {
                    int x = r + f[0];
                    int y = c + f[1];
                    if (inArea(grid, x, y)) {
                        if (visited[x][y]) {
                            continue;
                        }
                        if (grid[x][y] == t) {
                            queue.add(new int[]{x, y});
                            visited[x][y] = true;
                        } else {
                            grid[r][c] = color;
                        }
                    } else {
                        grid[r][c] = color;
                    }
                }
            }
        }
        return grid;
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }
}

