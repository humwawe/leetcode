package matrix.diagonal.sum;

/**
 * @author hum
 */
public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int result = 0;
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j || i == col - j - 1) {
                    result += mat[i][j];
                }
            }
        }
        return result;
    }
}
