package making.a.large.island;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class MakingALargeIsland {
    int color = 2;
    Map<Integer, Integer> map = new HashMap<>();
    int[][] fs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int count = helper(grid, i, j);
                    map.put(color++, count);
                }
            }
        }
        map.put(0, 0);
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int tmp = 1;
                    for (int[] f : fs) {
                        int x = i + f[0];
                        int y = j + f[1];
                        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                            int color = grid[x][y];
                            if (!set.contains(color)) {
                                tmp += map.get(color);
                                set.add(color);
                            }
                        }
                    }
                    result = Math.max(result, tmp);
                }
            }
        }
        return result == 0 ? row * col : result;
    }

    private int helper(int[][] grid, int i, int j) {
        grid[i][j] = color;
        int res = 1;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                res += helper(grid, x, y);
            }
        }
        return res;
    }
}
