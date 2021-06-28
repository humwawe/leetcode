package cyclically.rotating.a.grid;

/**
 * @author hum
 */
public class CyclicallyRotatingAGrid {
    public int[][] rotateGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt = Math.min(row, col) / 2;
        for (int i = 0; i < cnt; i++) {
            int c = 2 * (col - 2 * i) + 2 * (row - 2 - 2 * i);
            int t = k % c;
            while (t-- > 0) {
                int tmp = grid[i][i];
                for (int j = i; j < col - 1 - i; j++) {
                    grid[i][j] = grid[i][j + 1];
                }
                for (int j = i; j < row - 1 - i; j++) {
                    grid[j][col - 1 - i] = grid[j + 1][col - 1 - i];
                }
                for (int j = col - 1 - i; j > i; j--) {
                    grid[row - 1 - i][j] = grid[row - 1 - i][j - 1];
                }
                for (int j = row - 1 - i; j > i; j--) {
                    grid[j][i] = grid[j - 1][i];
                }
                grid[i + 1][i] = tmp;
            }
        }
        return grid;
    }
}
