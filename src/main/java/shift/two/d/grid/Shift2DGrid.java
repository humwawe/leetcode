package shift.two.d.grid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int[] t = new int[row];
        while (k-- > 0) {
            for (int i = 0; i < row; i++) {
                t[i] = grid[i][col - 1];
            }
            for (int i = col - 1; i >= 1; i--) {
                for (int j = 0; j < row; j++) {
                    grid[j][i] = grid[j][i - 1];
                }
            }
            grid[0][0] = t[row - 1];
            for (int i = 1; i < row; i++) {
                grid[i][0] = t[i - 1];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                list.add(grid[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
