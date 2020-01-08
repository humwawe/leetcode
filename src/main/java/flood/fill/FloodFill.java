package flood.fill;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int row = image.length;
        int col = image[0].length;
        boolean[][] vis = new boolean[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr, sc});
        vis[sr][sc] = true;
        int oldColor = image[sr][sc];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            image[poll[0]][poll[1]] = newColor;
            for (int[] f : fs) {
                int x = poll[0] + f[0];
                int y = poll[1] + f[1];
                if (x >= 0 && x < row && y >= 0 && y < col && !vis[x][y] && image[x][y] == oldColor) {
                    queue.add(new int[]{x, y});
                    vis[x][y] = true;
                }
            }
        }
        return image;
    }
}
