package island.perimeter;

/**
 * @author hum
 */
public class IslandPerimeter {
    int result = 0;
    int[][] fs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;

        int x = 0, y = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x != 0 || y != 0 || grid[0][0] == 1) {
                break;
            }
        }
        boolean[][] vis = new boolean[row][col];
        helper(grid, x, y, vis);
        return result;
    }

    private void helper(int[][] grid, int x, int y, boolean[][] vis) {
        vis[x][y] = true;
        result += count(grid, x, y);
        for (int[] f : fs) {
            int newX = f[0] + x;
            int newY = f[1] + y;
            if (newX < grid.length && newX >= 0 && newY < grid[0].length && newY >= 0 && !vis[newX][newY] && grid[newX][newY] == 1) {
                helper(grid, newX, newY, vis);
            }
        }
    }

    private int count(int[][] grid, int x, int y) {
        int count = 0;
        for (int[] f : fs) {
            int newX = f[0] + x;
            int newY = f[1] + y;
            if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                count++;
            } else {
                if (grid[newX][newY] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
