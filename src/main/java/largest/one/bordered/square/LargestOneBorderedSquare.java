package largest.one.bordered.square;

import java.util.Arrays;

/**
 * @author hum
 */
public class LargestOneBorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] up = new int[row + 1][col + 1];
        int[][] left = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    up[i][j] = 0;
                    left[i][j] = 0;
                } else {
                    up[i][j] = up[i - 1][j] + 1;
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(up));
        System.out.println(Arrays.deepToString(left));
        int result = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    continue;
                }
                int k = Math.min(up[i][j], left[i][j]);
                for (int l = k; l >= 1; l--) {
                    if (up[i][j - l + 1] >= l && left[i - l + 1][j] >= l) {
                        result = Math.max(result, l * l);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
