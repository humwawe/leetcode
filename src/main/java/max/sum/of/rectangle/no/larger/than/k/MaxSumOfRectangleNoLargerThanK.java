package max.sum.of.rectangle.no.larger.than.k;

/**
 * @author hum
 */
public class MaxSumOfRectangleNoLargerThanK {
    private int[][] sum;

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        sum = new int[row + 1][col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + matrix[i][j];
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i1 = 0; i1 < row; i1++) {
            for (int i2 = 0; i2 < col; i2++) {
                for (int j1 = i1; j1 < row; j1++) {
                    for (int j2 = i2 ; j2 < col; j2++) {
                        int tmp = helper(i1, i2, j1, j2);
                        if (tmp <= k) {
                            result = Math.max(result, tmp);
                        }
                    }
                }
            }
        }
        return result;
    }

    private int helper(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
