package find.valid.matrix.given.row.and.column.sums;

/**
 * @author hum
 */
public class FindValidMatrixGivenRowAndColumnSums {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int now = Math.min(rowSum[i], colSum[j]);
                res[i][j] = now;
                rowSum[i] -= now;
                colSum[j] -= now;
            }
        }
        return res;
    }
}
