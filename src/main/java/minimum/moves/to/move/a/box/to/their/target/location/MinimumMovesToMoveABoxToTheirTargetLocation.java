package minimum.moves.to.move.a.box.to.their.target.location;

import java.util.ArrayDeque;

/**
 * @author hum
 */
public class MinimumMovesToMoveABoxToTheirTargetLocation {
    public int minPushBox(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int sx = 0;
        int sy = 0;
        int bx = 0;
        int by = 0;
        int tx = 0;
        int ty = 0;
        boolean[][][][] vis = new boolean[row][col][row][col];
        int[][][][] dist = new int[row][col][row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, bx, by});
        dist[sx][sy][bx][by] = 0;
        vis[sx][sy][bx][by] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            if (p[2] == tx && p[3] == ty) {
                return dist[p[0]][p[1]][p[2]][p[3]];
            }
            for (int[] f : fs) {
                int x = p[0] + f[0];
                int y = p[1] + f[1];
                if (x < 0 || x >= row || y < 0 || y >= col) {
                    continue;
                }
                if (x == p[2] && y == p[3]) {
                    int newX = x + f[0];
                    int newY = y + f[1];
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                        continue;
                    }
                    if (vis[x][y][newX][newY]) {
                        continue;
                    }
                    if (grid[newX][newY] != '#') {
                        dist[x][y][newX][newY] = dist[p[0]][p[1]][x][y] + 1;
                        vis[x][y][newX][newY] = true;
                        queue.addLast(new int[]{x, y, newX, newY});
                    }
                } else {
                    if (vis[x][y][p[2]][p[3]]) {
                        continue;
                    }
                    if (grid[x][y] != '#') {
                        dist[x][y][p[2]][p[3]] = dist[p[0]][p[1]][p[2]][p[3]];
                        vis[x][y][p[2]][p[3]] = true;
                        queue.addFirst(new int[]{x, y, p[2], p[3]});
                    }
                }
            }
        }
        return -1;
    }
}
