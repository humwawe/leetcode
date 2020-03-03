package transpose.matrix;

/**
 * @author hum
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        int[][] result = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }
}
