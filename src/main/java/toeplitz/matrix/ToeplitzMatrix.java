package toeplitz.matrix;

/**
 * @author hum
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int j = 0;
            int index = i;
            int tmp = matrix[index][j];
            while (index < row && j < col) {
                if (matrix[index][j] != tmp) {
                    return false;
                }
                index++;
                j++;
            }
        }
        for (int j = 1; j < col; j++) {
            int i = 0;
            int index = j;
            int tmp = matrix[i][index];
            while (i < row && index < col) {
                if (matrix[i][index] != tmp) {
                    return false;
                }
                i++;
                index++;
            }
        }
        return true;
    }
}
