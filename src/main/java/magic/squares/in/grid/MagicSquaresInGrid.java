package magic.squares.in.grid;

/**
 * @author hum
 */
public class MagicSquaresInGrid {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagic(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean isMagic(int[][] grid, int x, int y) {
        boolean[] vis = new boolean[10];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                int temp = grid[i][j];
                if (temp < 1 || temp > 9 || vis[temp]) {
                    return false;
                }
                vis[temp] = true;
            }
        }
        int ave = grid[x + 1][y + 1] * 3;
        for (int i = x; i < x + 3; i++) {
            int sum = 0;
            for (int j = y; j < y + 3; j++) {
                sum += grid[i][j];
            }
            if (sum != ave) {
                return false;
            }
        }
        for (int j = y; j < y + 3; j++) {
            int sum = 0;
            for (int i = x; i < x + 3; i++) {
                sum += grid[i][j];
            }
            if (sum != ave) {
                return false;
            }
        }
        int sum = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        if (sum != ave) {
            return false;
        }
        int sum2 = grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];
        return sum2 == ave;
    }
}
