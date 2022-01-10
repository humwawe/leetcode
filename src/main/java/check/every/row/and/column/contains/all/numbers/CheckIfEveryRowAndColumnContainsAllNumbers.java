package check.every.row.and.column.contains.all.numbers;

/**
 * @author hum
 */
public class CheckIfEveryRowAndColumnContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] rows = new boolean[row][101];
        boolean[][] cols = new boolean[col][101];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                int num = matrix[r][c];
                if (rows[r][num] || cols[c][num]) {
                    return false;
                } else {
                    rows[r][num] = true;
                    cols[c][num] = true;
                }
            }
        }

        return true;
    }
}
