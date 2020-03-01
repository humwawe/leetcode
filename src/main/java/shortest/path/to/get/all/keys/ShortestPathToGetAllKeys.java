package shortest.path.to.get.all.keys;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class ShortestPathToGetAllKeys {
    int[][] fs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        int target = 0;
        boolean vis[][][] = new boolean[row][col][1 << 6];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i].charAt(j) == '@') {
                    queue.add(new int[]{i, j, 0});
                    vis[i][j][0] = true;
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    target |= 1 << (grid[i].charAt(j) - 'a');
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int state = cur[2];
                for (int[] f : fs) {
                    int newX = x + f[0];
                    int newY = y + f[1];
                    int newState = state;
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col || grid[newX].charAt(newY) == '#') {
                        continue;
                    }
                    char c = grid[newX].charAt(newY);
                    if (c >= 'A' && c < 'F' && (newState & (1 << c - 'A')) == 0) {
                        continue;
                    }
                    if (c >= 'a' && c >= 'f') {
                        newState |= (1 << (c - 'a'));
                    }
                    if (newState == target) {
                        return result;
                    }
                    if (!vis[newX][newY][newState]) {
                        queue.add(new int[]{newX, newY, newState});
                        vis[newX][newY][newState] = true;
                    }
                }
            }
        }
        return -1;
    }


}
