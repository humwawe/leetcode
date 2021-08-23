package maximum.matrix.sum;

/**
 * @author hum
 */
public class MaximumMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int row = matrix.length;
        int col = matrix.length;
        int cnt = 0;
        int min = (int) 1e8;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = Math.abs(matrix[i][j]);
                res += tmp;
                if (matrix[i][j] < 0) {
                    cnt++;
                }
                min = Math.min(min, tmp);
            }
        }
        if (cnt % 2 == 0) {
            return res;
        }
        return res - 2 * min;
    }
}
