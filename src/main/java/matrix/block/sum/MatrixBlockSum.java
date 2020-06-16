package matrix.block.sum;

import java.util.Arrays;

/**
 * @author hum
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] sum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(sum));
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int x = Math.min(row, i + k);
                int y = Math.min(col, j + k);
                int a = Math.max(1, i - k) - 1;
                int b = Math.max(1, j - k) - 1;
                result[i][j] = sum[x][y] - sum[x][b] - sum[a][y] + sum[a][b];
            }
        }
        return result;
    }

}
